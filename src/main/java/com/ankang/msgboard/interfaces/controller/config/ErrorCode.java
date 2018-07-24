package com.ankang.msgboard.interfaces.controller.config;

public enum ErrorCode {
    DUPLICATE_OBJECTS (101, "昵称或邮箱已被占用。");

    private final int code;

    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}