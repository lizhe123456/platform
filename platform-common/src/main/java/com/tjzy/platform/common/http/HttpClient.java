package com.tjzy.platform.common.http;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by lizhe on 2017/12/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
public class HttpClient {

    private static HttpClient instance;
    private static OkHttpClient httpClient;
    private static final Logger _log = LoggerFactory.getLogger(HttpClient.class);

    private HttpClient() {
        //构建形式如:new XXX.Builder().xxx().xxx().build();
        httpClient=new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    //json请求
    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    public static HttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    public String httpGet(String url,Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null && params.size() > 0) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            sb.append("?");
            for (Map.Entry<String, String> entry : entrySet) {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        Request request = new Request.Builder()
                .url(url + sb.toString())
                .get().build();
        Call call = httpClient.newCall(request);
        try {
            return call.execute().body().string();
        }catch (IOException e){
            e.printStackTrace();
            _log.error("HttpClient : ", url+"------get");
        }

        return null;
    }

    public String httpPost(String url, Object params){
        String json = com.alibaba.fastjson.JSON.toJSONString(params);
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = httpClient.newCall(request);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            _log.error("HttpClient : ", url+"------post");
        }
        return null;
    }
}
