package com.ankang.msgboard.infrastructure.persistence.mybatis.translator;

import com.ankang.msgboard.domain.model.Visitor;
import com.ankang.msgboard.infrastructure.persistence.mybatis.dataobject.VisitorDO;

import java.time.Instant;

/**
 * DO转换实体
 */
public class VisitorDoTranslator {

    public static Visitor trans(VisitorDO visitorDO) {
        Visitor.Builder builder = new Visitor.Builder(visitorDO.getEmail());
        builder.withId(visitorDO.getId());
        builder.withName(visitorDO.getName());
        builder.withBan(visitorDO.getBan());

        return builder.builder();
    }

    public static VisitorDO trans(Visitor visitor) {
        VisitorDO visitorDO = new VisitorDO();
        visitorDO.setEmail(visitor.getEmail());
        visitorDO.setName(visitor.getName());
        visitorDO.setMbDate(Instant.now());
        visitorDO.setBan(visitor.getBan());
        return visitorDO;
    }
}
