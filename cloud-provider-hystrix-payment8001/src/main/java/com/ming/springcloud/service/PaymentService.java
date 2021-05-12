package com.ming.springcloud.service;

/**
 * @author yzm
 * @date: 2021/5/1
 * @Description:
 * @Version: 1.0
 **/
public interface PaymentService {

    String paymentInfo_ok(Integer id);

    String paymentInfo_timeout(Integer id);

    String paymentCircuitBreaker_fallback(Integer id);

    String paymentCircuitBreaker(Integer id);
}
