package com.ankang.msgboard.domain.repository;

import com.ankang.msgboard.interfaces.controller.dto.MsgBoardDTO;
import com.ankang.msgboard.domain.model.Visitor;

import java.util.List;

public interface VisitorRepo {

    void save(Visitor visitor);

    Visitor find(String email);

    Boolean repeat(String name, String email);

    List<MsgBoardDTO> list(Integer articleId, Integer pageNum, Integer pageSize);
}
