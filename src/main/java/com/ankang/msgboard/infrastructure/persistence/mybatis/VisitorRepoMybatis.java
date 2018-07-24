package com.ankang.msgboard.infrastructure.persistence.mybatis;

import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.domain.model.Visitor;
import com.ankang.msgboard.domain.repository.VisitorRepo;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.VisitorDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.VisitorParam;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.MessageMapper;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.VisitorMapper;
import com.ankang.msgboard.infrastructure.persistence.mybatis.translator.MessageDOTranslator;
import com.ankang.msgboard.infrastructure.persistence.mybatis.translator.VisitorDoTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Repository
public class VisitorRepoMybatis implements VisitorRepo {

    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageDOTranslator messageDOTranslator;

    private final static Integer BAN_LIMIT = 3;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Visitor visitor) {
        Visitor oldVisitor = find(visitor.getEmail());

        // 访客信息已存在
        if (visitor.equals(oldVisitor)) {

            if (!oldVisitor.getBan().equals(visitor.getBan())) {
                VisitorDO visitorDO = new VisitorDO();
                visitorDO.setBan(visitor.getBan());
                visitorDO.setMbDate(Instant.now());
                VisitorParam param = new VisitorParam();
                param.or().andEmailEqualTo(visitor.getEmail());
                visitorMapper.updateByExampleSelective(visitorDO, param);
            }
            // 校验用户是否可发言
            if (visitor.getBan() <= BAN_LIMIT && visitor.getMessage() != null) {
                // 新增留言
                messageMapper.insert(messageDOTranslator.trans(visitor.getMessage(), oldVisitor.getId()));
            }
        } else {
            // 新增访客留言
            VisitorDO visitorDO = VisitorDoTranslator.trans(visitor);
            visitorMapper.insert(visitorDO);
            // 新增留言
            if (visitor.getMessage() != null) {
                messageMapper.insert(messageDOTranslator.trans(visitor.getMessage(), visitorDO.getId()));
            }
        }
    }

    private VisitorDO findDo(String email) {
        VisitorParam param = new VisitorParam();
        param.or().andEmailEqualTo(email);
        List<VisitorDO> visitorDOList = visitorMapper.selectByExample(param);
        return visitorDOList.isEmpty() ? null : visitorDOList.get(0);
    }

    @Override
    public Visitor find(String email) {
        VisitorDO visitorDO = findDo(email);
        return visitorDO != null ? VisitorDoTranslator.trans(visitorDO) : null;
    }

    @Override
    public Boolean repeat(String name, String email) {
        VisitorParam param = new VisitorParam();
        param.or().andNameEqualTo(name).andEmailNotEqualTo(email);
        param.or().andNameNotEqualTo(name).andEmailEqualTo(email);
        return visitorMapper.selectByExample(param).size() > 0;
    }

    @Override
    public List<MsgBoardDTO> list(Integer articleId, Integer pageNum, Integer pageSize) {
        return messageDOTranslator.trans(messageMapper.fetchMsgList(articleId, pageNum, pageSize));
    }
}
