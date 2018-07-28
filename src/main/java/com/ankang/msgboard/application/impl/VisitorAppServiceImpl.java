package com.ankang.msgboard.application.impl;

import com.ankang.msgboard.application.VisitorAppService;
import com.ankang.msgboard.domain.model.Message;
import com.ankang.msgboard.domain.model.Visitor;
import com.ankang.msgboard.domain.repository.VisitorRepo;
import com.ankang.msgboard.infrastructure.utils.SensitiveWordFilter;
import com.ankang.msgboard.interfaces.controller.dto.VisitorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitorAppServiceImpl implements VisitorAppService {

    @Autowired
    private SensitiveWordFilter sensitiveWordFilter;

    @Autowired
    private VisitorRepo visitorRepo;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void addMsg(VisitorDTO dto) {

        // 判断敏感词
        if (sensitiveWordFilter.check(dto.getName() + dto.getEmail() + dto.getMessage())) {
            Visitor visitor = visitorRepo.find(dto.getEmail());
            if (visitor != null) {
                visitor.addBan();
                visitorRepo.save(visitor);
            }
        } else {
            // 构造带留言实体
            Visitor.Builder builder = new Visitor.Builder(dto.getEmail());
            builder.withName(dto.getName());

            Message message = new Message(dto.getArticleId(), dto.getMessage(), dto.getQuote());
            builder.withMessage(message);

            // 清理缓存
            redisTemplate.delete(redisTemplate.keys("MB_ARTICLE_" + dto.getArticleId() + "_*"));
            visitorRepo.save(builder.builder());
        }
    }

    @Override
    public Boolean repeat(String name, String email) {
        return visitorRepo.repeat(name, email);
    }
}
