package com.ming.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yzm
 * @date: 2021/5/2
 * @Description:
 * @Version: 1.0
 **/
@Component
public class PaymentFallbackService implements OrderFeignHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeout";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeout";
    }

}
