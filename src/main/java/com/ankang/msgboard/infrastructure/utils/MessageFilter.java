package com.ankang.msgboard.infrastructure.utils;

import org.springframework.stereotype.Component;

@Component
public class MessageFilter {

    public boolean ContainIllegalMsg(String message) {
        return false;
    }
}
