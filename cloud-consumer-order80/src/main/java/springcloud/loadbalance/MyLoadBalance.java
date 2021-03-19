package springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 自定义负载均衡算法
@Component // 注入spring
public class MyLoadBalance implements BalanceInterface{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getIndex(){
        int next;
        // 获取当前的值
        int current;
        do {
            current = atomicInteger.get();
            next = (current >= Integer.MAX_VALUE) ? 0: current + 1;
        }while (!atomicInteger.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getIndex() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
