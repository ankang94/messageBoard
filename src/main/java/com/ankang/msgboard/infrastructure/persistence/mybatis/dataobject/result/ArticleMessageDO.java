package com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.result;

import java.io.Serializable;
import java.time.Instant;

public class ArticleMessageDO implements Serializable {

    private String id;

    private String visitor;

    private String message;

    private Instant time;

    private String quoteName;

    private String quoteMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    public String getQuoteMessage() {
        return quoteMessage;
    }

    public void setQuoteMessage(String quoteMessage) {
        this.quoteMessage = quoteMessage;
    }
}
