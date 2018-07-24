package com.ankang.msgboard.interfaces.controller.vo;

import java.io.Serializable;

public class MessageVO implements Serializable {
    private String id;
    private String name;
    private String message;
    private String time;
    private MessageQuoteVO quote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MessageQuoteVO getQuote() {
        return quote;
    }

    public void setQuote(MessageQuoteVO quote) {
        this.quote = quote;
    }
}
