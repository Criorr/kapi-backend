package com.zk.kapiinterface.controller;

import com.zk.kapiclientsdk.model.User;
import com.zk.kapiclientsdk.utils.SignUtils;
import com.zk.kapiinterface.common.BaseResponse;
import com.zk.kapiinterface.common.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;

/**
 * NameController
 * 名称API
 * @author ZhengKai
 * @date 2023/7/29
 */
@RestController()
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("zk"));
        return "GET 你的名字是：" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是：" + name;
    }

    @PostMapping("/user")
    public BaseResponse<String> getUsernameByPost(@RequestBody User user) {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String body = request.getHeader("body");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        // TODO 实际情况应该去数据库中查是否已分配给用户
//        // select accessKey, secretKey from user where accessKey = "accessKey"
//        if (!accessKey.equals("zkapi")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 100000L) {
//            throw new RuntimeException("无权限");
//        }
//        // TODO 时间与当前时间不超过5分钟
////        if (timestamp) {
////
////        }
//        // TODO 实际情况 在前面查询是否分配给用户的时候就把secretKey也获取到了
//        String serverSign = SignUtils.genSign(body, "abcdefg");
//        if (!serverSign.equals(sign)) {
//            throw new RuntimeException("无权限");
//        }
        // 调用次数统计
        return ResultUtils.success("POST 用户名是：" + user.getUsername());
        // return ;

    }
}
