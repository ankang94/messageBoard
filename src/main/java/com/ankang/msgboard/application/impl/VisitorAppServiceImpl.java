package com.ankang.msgboard.application.impl;

import com.ankang.msgboard.interfaces.controller.dto.VisitorDTO;
import com.ankang.msgboard.application.VisitorAppService;
import com.ankang.msgboard.domain.model.Message;
import com.ankang.msgboard.domain.model.Visitor;
import com.ankang.msgboard.domain.repository.VisitorRepo;
import com.ankang.msgboard.infrastructure.utils.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorAppServiceImpl implements VisitorAppService {


    @Autowired
    private MessageFilter messageFilter;

    @Autowired
    private VisitorRepo visitorRepo;

    private static final Integer BAN_COUNT = 1;

    @Override
    public void addMsg(VisitorDTO dto) {

        // 判断敏感词
        if (messageFilter.ContainIllegalMsg(dto.getMessage())) {
            Visitor visitor = visitorRepo.find(dto.getEmail());
            if (visitor != null) {
                visitor.addBan();
            }
            else {
                Visitor.Builder builder = new Visitor.Builder(dto.getEmail());
                builder.withName(dto.getName());
                builder.withBan(BAN_COUNT);
                visitor = builder.builder();
            }

            visitorRepo.save(visitor);
        } else {
            // 构造带留言实体
            Visitor.Builder builder = new Visitor.Builder(dto.getEmail());
            builder.withName(dto.getName());

            Message message = new Message(dto.getArticleId(), dto.getMessage(), dto.getQuote());
            builder.withMessage(message);

            visitorRepo.save(builder.builder());
        }
    }

    @Override
    public Boolean repeat(String name, String email) {
        return visitorRepo.repeat(name, email);
    }
}
