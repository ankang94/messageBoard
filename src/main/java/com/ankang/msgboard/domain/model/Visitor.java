package com.ankang.msgboard.domain.model;

import com.ankang.msgboard.domain.shared.Entity;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Visitor implements Entity {

    private static final Integer DEFAULT_BAN_LIMIT = 0;

    private Integer id;

    private String email;

    private String name;

    private Message message;

    private Integer ban;

    private Visitor(String email) {
        this.email = email;
        this.ban = DEFAULT_BAN_LIMIT;
    }

    public static class Builder {
        private Visitor instance;

        public Builder(String email) {
            Preconditions.checkArgument(StringUtils.isNotBlank(email));
            // 邮件格式校验
            instance = new Visitor(email);
        }

        public Builder withId(Integer id) {
            Preconditions.checkNotNull(id);
            instance.id = id;
            return this;
        }

        public Builder withName(String name) {
            Preconditions.checkArgument(StringUtils.isNotBlank(name));
            instance.name = name;
            return this;
        }

        public Builder withMessage(Message message) {
            Preconditions.checkNotNull(message);
            instance.message = message;
            return this;
        }

        public Builder withBan(Integer ban) {
            Preconditions.checkNotNull(ban);
            instance.ban = ban;
            return this;
        }

        public Visitor builder() {
            return instance;
        }
    }

    public void addBan() {
        this.ban += 1;
    }

    @Override
    public boolean sameIdentifyAs(Object other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor other = (Visitor) o;
        return new EqualsBuilder().append(email, other.email).isEquals();
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Message getMessage() {
        return message;
    }

    public Integer getBan() {
        return ban;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(email)
                .append(name)
                .append(message)
                .append(ban)
                .toHashCode();
    }
}
