package com.ankang.msgboard.domain.model;

import com.ankang.msgboard.domain.shared.ValueObject;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Message
 */
public class Message implements ValueObject {

    private Integer articleId;

    private String message;

    private Integer parentId;

    public Message(Integer articleId, String message, Integer parentId) {
        Preconditions.checkArgument(message != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(message));
        this.articleId = articleId;
        this.message = message;
        this.parentId = parentId;
    }

    @Override
    public boolean sameValueAs(Object other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message other = (Message) o;
        return new EqualsBuilder().append(articleId, other.articleId)
                .append(message, other.message)
                .append(parentId, other.parentId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(articleId)
                .append(message)
                .append(parentId)
                .toHashCode();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public String getMessage() {
        return message;
    }

    public Integer getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "articleId=" + articleId +
                ", message='" + message + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
