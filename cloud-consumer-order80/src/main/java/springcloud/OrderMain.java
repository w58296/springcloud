package springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import ribbonrule.MyRule;

@SpringBootApplication
@EnableEurekaClient
// 自定义ribbon负载均衡算法
@RibbonClient(name = "CLOUD-PROVIDER-SERVICE", configuration = MyRule.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }
}
