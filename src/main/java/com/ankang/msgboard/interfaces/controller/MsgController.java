package com.ankang.msgboard.interfaces.controller;

import com.ankang.msgboard.application.MessageAppService;
import com.ankang.msgboard.application.VisitorAppService;
import com.ankang.msgboard.interfaces.controller.config.ErrorCode;
import com.ankang.msgboard.interfaces.controller.config.PageInfo;
import com.ankang.msgboard.interfaces.controller.config.RestResponse;
import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.interfaces.controller.dto.VisitorDTO;
import com.ankang.msgboard.interfaces.controller.translator.MessageVoTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MsgController {

    @Autowired
    private VisitorAppService visitorAppService;

    @Autowired
    private MessageAppService messageAppService;

    @Resource
    private RedisTemplate redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(MsgController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResponse listMsg(@RequestParam("articleId") Integer articleId,
                                @RequestParam("pageNum") Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize) {
        PageInfo pageInfo = new PageInfo(pageNum, pageSize);
        List<MsgBoardDTO> result = messageAppService.list(articleId, pageInfo);
        return RestResponse.page(MessageVoTranslator.trans(result), pageInfo);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public RestResponse newMsg(@RequestParam("articleId") Integer articleId,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam(value = "quote", required = false) Integer quote,
                               @RequestParam("message") String message) {

        if (visitorAppService.repeat(name, email)) {
            return RestResponse.error(ErrorCode.DUPLICATE_OBJECTS.getCode(), ErrorCode.DUPLICATE_OBJECTS.getDescription());
        }

        VisitorDTO visitorDTO = new VisitorDTO();
        visitorDTO.setArticleId(articleId);
        visitorDTO.setName(name);
        visitorDTO.setEmail(email);
        visitorDTO.setMessage(message);
        visitorDTO.setQuote(quote);
        visitorAppService.addMsg(visitorDTO);
        return RestResponse.empty();
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public RestResponse refresh(@RequestParam("articles") String articleIds) {
        Arrays.stream(articleIds.split(",")).forEach(x -> {
            try {
                redisTemplate.delete(redisTemplate.keys("MB_ARTICLE_" + Integer.valueOf(x) + "_*"));
            } catch (NumberFormatException e) {
                logger.debug(e.getMessage());
            }
        });
        return RestResponse.empty();
    }
}
