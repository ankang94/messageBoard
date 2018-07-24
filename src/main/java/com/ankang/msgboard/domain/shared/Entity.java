package com.ankang.msgboard.domain.shared;

/**
 * @author ankang
 * @date 2018/07/11
 */
public interface Entity<T> {

    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other
     * @return
     */
    boolean sameIdentifyAs(T other);
}
