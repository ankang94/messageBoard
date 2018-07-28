package com.ankang.msgboard.interfaces.controller.translator;

import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.infrastructure.utils.FormatTools;
import com.ankang.msgboard.interfaces.controller.vo.MessageQuoteVO;
import com.ankang.msgboard.interfaces.controller.vo.MessageVO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MessageVoTranslator {
    public static List<MessageVO> trans(List<MsgBoardDTO> list) {
        return list.stream().map(x -> {
            MessageVO vo = new MessageVO();
            vo.setId(x.getId());
            vo.setName(x.getName());
            vo.setMessage(x.getMessage());
            vo.setTime(x.getTime());
            if (StringUtils.isNotEmpty(x.getQuoteName())) {
                MessageQuoteVO quote = new MessageQuoteVO();
                quote.setName(x.getQuoteName());
                quote.setMessage(x.getQuoteMessage());
                vo.setQuote(quote);
            }
            return vo;
        }).collect(Collectors.toList());
    }
}
