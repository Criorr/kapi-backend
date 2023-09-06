package com.zk.kapiinterface;

import com.zk.kapiclientsdk.client.KapiClient;

import com.zk.kapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class KapiInterfaceApplicationTests {

    @Resource
    KapiClient kapiClient;
    @Test
    void contextLoads() {
        String nameByGet = kapiClient.getNameByGet("zk");
        String nameByPost = kapiClient.getNameByPost("zk");
        User user = new User();
        user.setUsername("zk");
        String usernameByPost = kapiClient.getUsernameByPost(user);
        System.out.println(nameByGet);
        System.out.println(nameByPost);
        System.out.println(usernameByPost);

    }

}
