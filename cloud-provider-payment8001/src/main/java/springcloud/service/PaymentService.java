package springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import springcloud.entities.Payment;


public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
