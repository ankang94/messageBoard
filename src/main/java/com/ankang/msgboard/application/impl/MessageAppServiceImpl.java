package com.ankang.msgboard.application.impl;

import com.ankang.msgboard.application.MessageAppService;
import com.ankang.msgboard.domain.repository.VisitorRepo;
import com.ankang.msgboard.infrastructure.persistence.mybatis.mapper.MessageMapper;
import com.ankang.msgboard.interfaces.controller.config.PageInfo;
import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MessageAppServiceImpl implements MessageAppService {

    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private MessageMapper messageMapper;

    @Resource
    private RedisTemplate redisTemplate;

    private final static String LEN = "MB_ARTICLE_%s_LEN";

    private final static String KEY = "MB_ARTICLE_%s_PAGE_%s_SIZE_%s";

    @Override
    public List<MsgBoardDTO> list(Integer articleId, PageInfo pageInfo) {

        String key = String.format(LEN, articleId);
        if (redisTemplate.hasKey(key)) {
            pageInfo.setTotal(Long.valueOf((String) redisTemplate.opsForValue().get(key)));
        } else {
            pageInfo.setTotal(messageMapper.countMsg(articleId));
            redisTemplate.opsForValue().set(key, String.valueOf(pageInfo.getTotal()), 12, TimeUnit.HOURS);
        }

        List result = Lists.newArrayList();

        String keys = String.format(KEY, articleId, pageInfo.getPageNum(), pageInfo.getPageSize());
        if (pageInfo.getTotal() > 0) {
            if (redisTemplate.hasKey(keys)) {
                result = redisTemplate.opsForList().range(keys, 0, -1);
            } else {
                result = visitorRepo.list(articleId, pageInfo.getPageNum(), pageInfo.getPageSize());
                redisTemplate.opsForList().rightPushAll(keys, result);
                redisTemplate.expire(keys, 12, TimeUnit.HOURS);
            }
        }

        return result;
    }
}
