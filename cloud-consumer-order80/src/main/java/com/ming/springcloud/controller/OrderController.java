package com.ming.springcloud.controller;

import com.ming.springcloud.entity.CommentResult;
import com.ming.springcloud.entity.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
@RestController
@Log4j2
public class OrderController {

    //    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        return this.restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommentResult<Payment> getPaymentById2(@PathVariable("id") Long id) {

        ResponseEntity<CommentResult> forEntity = this.restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommentResult<>(444,"操作失败！！！");
        }
    }

}
