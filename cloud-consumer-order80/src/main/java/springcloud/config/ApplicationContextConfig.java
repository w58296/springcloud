package springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    // 负载均衡配置
//    @LoadBalanced 自定义轮询算法时不需要这个注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
