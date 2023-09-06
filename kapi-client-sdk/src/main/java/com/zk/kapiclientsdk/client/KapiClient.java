package com.zk.kapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zk.kapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.zk.kapiclientsdk.utils.SignUtils.genSign;

/**
 * KapiClient
 * 调用第三方API的客户端
 * @author ZhengKai
 * @date 2023/7/29
 */
public class KapiClient {

    private String accessKey;

    private String secretKey;

    private static final String GATEWAY_HOST = "http://127.0.0.1:8082";

    public KapiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result3= HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }


    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result3= HttpUtil.post( GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result3);
        return result3;
    }


    /**
     * 密码不能直接发送
     * 通过签名（ak sk 结合进行单向加密，验证时使用同样的方式进行加密，比对加密后的字符串）保证传输安全
     * 重放问题解决（使用随机数，API提供端进行随机数的记录，保证每次传递的唯一性，再加上时间戳设置有效时长，进行随机数判断的优化）
     * @param body
     * @return
     */
    private Map<String,String> getHeaderMap(String body) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("accessKey", accessKey);
//        headerMap.put("secretKey", secretKey);
        // 随机数
        headerMap.put("nonce", RandomUtil.randomNumbers(5));
        headerMap.put("body", body);
        // 时间戳
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        // 签名
        headerMap.put("sign", genSign(body, secretKey));
        return headerMap;
    };





    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse result2 = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(result2.getStatus());
        System.out.println(result2);
        return result2.body();
    }
}
