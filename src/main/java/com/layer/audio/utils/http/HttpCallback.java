package com.layer.audio.utils.http;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Http请求回调抽象类
 *
 * @author cdyangyang18
 */
public abstract class HttpCallback {

    /**
     * 请求之前调用
     */
    public abstract void onRequestBefore();

    /**
     * 请求失败调用（网络问题）
     *
     * @param request 请求
     * @param e       异常
     */
    public abstract void onFailure(Request request, Exception e);

    /**
     * 请求成功而且没有错误的时候调用
     *
     * @param response   响应
     * @param statusCode 状态码
     * @param result     结果
     */
    public abstract void onSuccess(Response response, Integer statusCode, String result);

    /**
     * 请求成功但是有错误的时候调用
     *
     * @param response   响应
     * @param statusCode 状态码
     * @param result     结果
     * @param e          异常
     */
    public abstract void onError(Response response, Integer statusCode, String result, Exception e);

}
