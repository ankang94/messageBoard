package com.ankang.msgboard.application;

import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.interfaces.controller.config.PageInfo;

import java.util.List;

public interface MessageAppService {

    List<MsgBoardDTO> list(Integer articleId, PageInfo pageInfo);
}
