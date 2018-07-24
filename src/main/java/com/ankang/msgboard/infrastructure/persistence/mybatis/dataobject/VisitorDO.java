package com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject;

import java.io.Serializable;
import java.time.Instant;

public class VisitorDO implements Serializable {
    private Integer id;

    private String name;

    private String email;

    private Integer ban;

    private Instant mbDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getBan() {
        return ban;
    }

    public void setBan(Integer ban) {
        this.ban = ban;
    }

    public Instant getMbDate() {
        return mbDate;
    }

    public void setMbDate(Instant mbDate) {
        this.mbDate = mbDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", ban=").append(ban);
        sb.append(", mbDate=").append(mbDate);
        sb.append("]");
        return sb.toString();
    }
}