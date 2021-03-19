package springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface BalanceInterface {
    // 返回一个服务实例
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
