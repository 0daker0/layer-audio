package com.layer.audio.utils.http;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Http 请求工具类
 *
 * @author cdyangyang18
 */
@NoArgsConstructor
public class HttpClient {

    private final static Logger LOG= LoggerFactory.getLogger(HttpClient.class);

    private static final String SUCCESS_MSG = "HTTP请求成功";
    private static final String FAIL_MSG = "HTTP请求失败";
    private static final String LOST_CONNECTION = "失去连接！请检查网络配置！";
    private static HttpClient mHttpClientInstance;
    private static OkHttpClient mOKHttpClientInstance = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    public static synchronized HttpClient getInstance() {
        if (mHttpClientInstance == null) {
            mHttpClientInstance = new HttpClient();
        }
        return mHttpClientInstance;
    }

    /**
     * 同步GET请求
     *
     * @param url 请求地址
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse get(String url) {
        LOG.debug("HTTP准备发送同步GET请求");
        return syncRequest(buildRequest(url, null, null, HttpMethod.GET));
    }

    /**
     * 异步GET请求
     *
     * @param url      请求地址
     * @param callback 回调函数
     */
    public void get(String url, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步GET请求");
        asyncRequest(buildRequest(url, null, null, HttpMethod.GET), callback);
    }

    /**
     * 同步GET请求（带请求头）
     *
     * @param url     请求地址
     * @param headers 请求头
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse get(String url, Map<String, Object> headers) {
        LOG.debug("HTTP准备发送同步GET请求");
        return syncRequest(buildRequest(url, headers, null, HttpMethod.GET));
    }

    /**
     * 异步GET请求（带请求头）
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param callback 回调函数
     */
    public void get(String url, Map<String, Object> headers, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步GET请求");
        asyncRequest(buildRequest(url, headers, null, HttpMethod.GET), callback);
    }

    /**
     * 异步POST请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse post(String url, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步POST请求");
        return syncRequest(buildRequest(url, null, params, HttpMethod.POST));
    }

    /**
     * 异步POST请求
     *
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调函数
     */
    public void post(String url, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步POST请求");
        asyncRequest(buildRequest(url, null, params, HttpMethod.POST), callback);
    }

    /**
     * 异步POST请求（带请求头）
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse post(String url, Map<String, Object> headers, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步POST请求");
        return syncRequest(buildRequest(url, headers, params, HttpMethod.POST));
    }

    /**
     * 异步POST请求（带请求头）
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调函数
     */
    public void post(String url, Map<String, Object> headers, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步POST请求");
        asyncRequest(buildRequest(url, headers, params, HttpMethod.POST), callback);
    }

    /**
     * 同步PUT请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse put(String url, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步PUT请求");
        return syncRequest(buildRequest(url, null, params, HttpMethod.PUT));
    }

    /**
     * 异步PUT请求
     *
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调函数
     */
    public void put(String url, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步PUT请求");
        asyncRequest(buildRequest(url, null, params, HttpMethod.PUT), callback);
    }

    /**
     * 同步PUT请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse put(String url, Map<String, Object> headers, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步PUT请求");
        return syncRequest(buildRequest(url, headers, params, HttpMethod.PUT));
    }

    /**
     * 异步PUT请求（带请求头）
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调函数
     */
    public void put(String url, Map<String, Object> headers, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步PUT请求");
        asyncRequest(buildRequest(url, headers, params, HttpMethod.PUT), callback);
    }

    /**
     * 同步PATCH请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse patch(String url, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步PATCH请求");
        return syncRequest(buildRequest(url, null, params, HttpMethod.PATCH));
    }

    /**
     * 异步PATCH请求
     *
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调函数
     */
    public void patch(String url, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步PATCH请求");
        asyncRequest(buildRequest(url, null, params, HttpMethod.PATCH), callback);
    }

    /**
     * 同步PATCH请求（带请求头）
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse patch(String url, Map<String, Object> headers, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步PATCH请求");
        return syncRequest(buildRequest(url, null, params, HttpMethod.PATCH));
    }

    /**
     * 异步PATCH请求（带请求头）
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调函数
     */
    public void patch(String url, Map<String, Object> headers, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步PATCH请求");
        asyncRequest(buildRequest(url, headers, params, HttpMethod.PATCH), callback);
    }

    /**
     * 同步DELETE请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse delete(String url, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步DELETE请求");
        return syncRequest(buildRequest(url, null, params, HttpMethod.DELETE));
    }

    /**
     * 异步DELETE请求
     *
     * @param url      请求地址
     * @param params   参数
     * @param callback 回调函数
     */
    public void delete(String url, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步DELETE请求");
        asyncRequest(buildRequest(url, null, params, HttpMethod.DELETE), callback);
    }

    /**
     * 同步DELETE请求（带请求头）
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  参数
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse delete(String url, Map<String, Object> headers, Map<String, Object> params) {
        LOG.debug("HTTP准备发送同步DELETE请求");
        return syncRequest(buildRequest(url, headers, params, HttpMethod.DELETE));
    }

    /**
     * 异步DELETE请求（带请求头）
     *
     * @param url      请求地址
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调函数
     */
    public void delete(String url, Map<String, Object> headers, Map<String, Object> params, HttpCallback callback) {
        LOG.debug("HTTP准备发送异步DELETE请求");
        asyncRequest(buildRequest(url, headers, params, HttpMethod.DELETE), callback);
    }

    /**
     * 封装同步请求
     *
     * @param request 请求
     * @return HttpResponse 1:是否成功 2:状态码 3:返回信息
     */
    public HttpResponse syncRequest(final Request request) {
        LOG.debug("HTTP开始进行同步请求");
        try {
            Response response = mOKHttpClientInstance.newCall(request).execute();
            Boolean isSuccess = response.isSuccessful();
            Integer code = response.code();
            String result = response.body().string();
            LOG.info(response.isSuccessful() ? SUCCESS_MSG : FAIL_MSG);
            LOG.info("请求结果：{}", result);
            return HttpResponse.builder().isSuccess(isSuccess).code(code).result(result).build();
        } catch (IOException e) {
            LOG.info(FAIL_MSG);
            LOG.info(LOST_CONNECTION);
            return HttpResponse.builder().isSuccess(false).code(404).result(null).build();
        }
    }

    /**
     * 封装异步请求
     *
     * @param request  请求
     * @param callback 回调函数
     */
    private void asyncRequest(final Request request, final HttpCallback callback) {
        LOG.debug("HTTP开始进行异步请求前预操作");
        callback.onRequestBefore();
        LOG.debug("HTTP开始进行异步请求");
        mOKHttpClientInstance.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LOG.info(FAIL_MSG);
                LOG.info(LOST_CONNECTION);
                callback.onFailure(request, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Boolean isSuccess = response.isSuccessful();
                Integer code = response.code();
                String result = response.body().string();
                LOG.info(isSuccess ? SUCCESS_MSG : FAIL_MSG);
                LOG.info("请求结果：{}", result);
                if (response.isSuccessful()) {
                    callback.onSuccess(response, code, result);
                } else {
                    callback.onError(response, code, result, null);
                }
            }
        });
    }

    /**
     * 构建请求对象
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return Request
     */
    private Request buildRequest(String url, Map<String, Object> headers, Map<String, Object> params, HttpMethod method) {
        LOG.info("请求地址：{}", url);
        LOG.info("请求方法：{}", method);
        LOG.info("请求参数：{}", params);
        LOG.debug("HTTP开始构建请求对象");
        // 初始化请求
        Request.Builder builder = new Request.Builder().url(url);
        // 添加请求头
        if (headers != null) {
            headers.forEach((k, v) -> builder.addHeader(k, String.valueOf(v)));
        }
        // 添加请求参数
        switch (method) {
            case GET:
                builder.get();
                break;
            case POST:
                builder.post(buildRequestBody(params));
                break;
            case PUT:
                builder.put(buildRequestBody(params));
                break;
            case PATCH:
                builder.patch(buildRequestBody(params));
                break;
            case DELETE:
                builder.delete(buildRequestBody(params));
                break;
            default:
                throw new UnsupportedOperationException("尚未支持的请求类型");
        }
        return builder.build();
    }

    /**
     * 通过Map的键值对构建请求对象的body
     *
     * @param params 参数集
     * @return RequestBody
     */
    private RequestBody buildRequestBody(Map<String, Object> params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            params.forEach((key, value) -> builder.add(key, String.valueOf(value)));
        }
        return builder.build();
    }

}
