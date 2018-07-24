package com.ankang.msgboard.application;

import com.ankang.msgboard.interfaces.controller.dto.VisitorDTO;

public interface VisitorAppService {

    void addMsg(VisitorDTO visitorDTO);

    Boolean repeat(String name, String email);
}
