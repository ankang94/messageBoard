package com.ankang.msgboard.application.impl;

import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.application.MessageAppService;
import com.ankang.msgboard.domain.repository.VisitorRepo;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.MessageMapper;
import com.ankang.msgboard.interfaces.controller.config.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageAppServiceImpl implements MessageAppService {

    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<MsgBoardDTO> list(Integer articleId, PageInfo pageInfo) {
        pageInfo.setTotal(messageMapper.countMsg(articleId));
        if (pageInfo.getTotal() > 0) {
            return visitorRepo.list(articleId, pageInfo.getPageNum(), pageInfo.getPageSize());
        }
        return Lists.newArrayList();
    }
}
