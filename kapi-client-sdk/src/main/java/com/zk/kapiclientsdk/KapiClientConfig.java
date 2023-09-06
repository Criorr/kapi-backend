package com.zk.kapiclientsdk;

import com.zk.kapiclientsdk.client.KapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * KapiClientConfig
 *
 * @author ZhengKai
 * @date 2023/7/30
 */
@Configuration
// 此处的kapi.client 就是去properties.yml 中设置值的前缀
@ConfigurationProperties("kapi.client")
@Data
@ComponentScan
public class KapiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public KapiClient KapiClient() {
        return  new KapiClient(accessKey,secretKey);
    }

}
