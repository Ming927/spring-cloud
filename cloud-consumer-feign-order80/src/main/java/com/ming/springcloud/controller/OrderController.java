package com.ming.springcloud.controller;

import com.ming.springcloud.entity.CommentResult;
import com.ming.springcloud.entity.Payment;
import com.ming.springcloud.service.PaymentFeignService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yzm
 * @date: 2021/4/28
 * @Description:
 * @Version: 1.0
 **/
@RestController
@Log4j2
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
