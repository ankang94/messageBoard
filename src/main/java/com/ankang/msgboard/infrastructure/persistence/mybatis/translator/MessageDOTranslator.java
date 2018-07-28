package com.ankang.msgboard.infrastructure.persistence.mybatis.translator;

import com.ankang.msgboard.domain.model.Message;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.MessageDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.MessageParam;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.result.ArticleMessageDO;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.MessageMapper;
import com.ankang.msgboard.infrastructure.utils.FormatTools;
import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageDOTranslator {

    @Autowired
    private MessageMapper messageMapper;

    public MessageDO trans(Message message, Integer visitorId) {
        MessageDO messageDO = new MessageDO();
        messageDO.setVisitor(visitorId);
        messageDO.setArticle(message.getArticleId());
        messageDO.setMessage(message.getMessage());
        messageDO.setMbDate(Instant.now());

        if (message.getParentId() != null) {
            MessageParam param = new MessageParam();
            param.or().andIdEqualTo(message.getParentId());
            if (messageMapper.selectByExample(param).size() > 0) {
                messageDO.setParent(message.getParentId());
            }
        }

        return messageDO;
    }

    public List<MsgBoardDTO> trans(List<ArticleMessageDO> list) {
        return list.stream().map(
                x -> {
                    MsgBoardDTO dto = new MsgBoardDTO();
                    dto.setId(x.getId());
                    dto.setName(x.getVisitor());
                    dto.setMessage(x.getMessage());
                    dto.setTime(FormatTools.format(x.getTime()));
                    dto.setQuoteName(x.getQuoteName());
                    dto.setQuoteMessage(x.getQuoteMessage());
                    return dto;
                }
        ).collect(Collectors.toList());
    }
}
