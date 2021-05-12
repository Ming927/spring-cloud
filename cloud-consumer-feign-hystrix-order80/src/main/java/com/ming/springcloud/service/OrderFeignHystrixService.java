package com.ming.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yzm
 * @date: 2021/5/1
 * @Description:
 * @Version: 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface OrderFeignHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/circuit/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
