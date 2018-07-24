package com.ankang.msgboard.interfaces.controller.config;

import com.google.common.collect.Maps;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;

/**
 * Rest接口统一格式
 */
public class RestResponse<T> {

    /**
     * 业务是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 数据字段
     */
    private T data;

    /**
     * 成功
     */
    public RestResponse() {
        this.success = true;
        this.message = "ok";
    }

    /**
     * 成功
     *
     * @param data
     */
    public RestResponse(T data) {
        this.success = true;
        this.data = data;
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     */
    public RestResponse(Integer code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    /**
     * data字段留空
     *
     * @return
     */
    public static RestResponse empty() {
        return new RestResponse();
    }

    /**
     * 返回错误信息
     *
     * @param code
     * @param errMsg
     * @return
     */
    public static RestResponse error(Integer code, String errMsg) {
        return new RestResponse(code, errMsg);
    }

    /**
     * 返回对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResponse single(T data) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("detail", data);

        return new RestResponse(result);
    }

    /**
     * 数据列表返回
     *
     * @param list
     * @return
     */
    public static RestResponse list(List<? extends Object> list) {
        return RestResponse.page(list, null);
    }

    /**
     * 分页结果返回
     *
     * @param list
     * @param pageInfo
     * @return
     */
    public static RestResponse page(List<? extends Object> list, PageInfo pageInfo) {
        Preconditions.checkNotNull(list);
        Map<String, Object> data = Maps.newHashMap();
        data.put("list", list);

        if (null != pageInfo) {
            Map<String, Object> pagination = Maps.newHashMap();
            pagination.put("current", pageInfo.getPageNum());
            pagination.put("size", pageInfo.getPageSize());
            pagination.put("total", pageInfo.getTotal());
            data.put("pagination", pagination);
        }

        return new RestResponse<>(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
