package com.ankang.msgboard.domain.shared;

/**
 * @author ankang
 * @date 2018/07/11
 */
public interface ValueObject<T> {

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other
     * @return
     */
    boolean sameValueAs(T other);
}
