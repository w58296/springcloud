package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
@Component
// 接口相当于在Payment的Controller上加了一层, 所以相关的参数和返回值必须一致,以及访问的路径
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    // feign超时测试
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
