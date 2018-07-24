package com.ankang.msgboard.interfaces.controller.config;

import java.io.Serializable;

/**
 * 分页
 */
public final class PageInfo implements Serializable {
    /**
     * 默认页数
     */
    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 总数
     */
    private long total;

    /**
     * 起始行
     */
    private int offset;

    public PageInfo() {
        this.pageNum = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public PageInfo(int pageNum, int pageSize) {
        this.pageNum = pageNum < 1 ? 1 : pageNum;
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        this.offset = (this.pageNum - 1) * this.pageSize;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotal() {
        return total;
    }

    public int getOffset() {
        return offset;
    }
}
