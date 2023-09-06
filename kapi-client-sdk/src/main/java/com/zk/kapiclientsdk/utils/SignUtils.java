package com.zk.kapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * SignUtils
 *
 * @author ZhengKai
 * @date 2023/7/30
 */
public class SignUtils {
    /**
     * 签名生成（单向生成 不可逆）
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String  body, String secretKey) {
        String context = body + "." + secretKey;
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        return md5.digestHex(context);
    }
}
