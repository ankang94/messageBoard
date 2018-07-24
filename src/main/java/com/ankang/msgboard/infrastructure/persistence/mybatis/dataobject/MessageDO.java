package com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject;

import java.io.Serializable;
import java.time.Instant;

public class MessageDO implements Serializable {
    private Integer id;

    private Integer visitor;

    private Integer article;

    private Integer parent;

    private Instant mbDate;

    private String message;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public Integer getArticle() {
        return article;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Instant getMbDate() {
        return mbDate;
    }

    public void setMbDate(Instant mbDate) {
        this.mbDate = mbDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", visitor=").append(visitor);
        sb.append(", article=").append(article);
        sb.append(", parent=").append(parent);
        sb.append(", mbDate=").append(mbDate);
        sb.append(", message=").append(message);
        sb.append("]");
        return sb.toString();
    }
}