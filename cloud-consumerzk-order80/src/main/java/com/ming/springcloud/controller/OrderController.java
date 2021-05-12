package com.ming.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getRestTemplate(){
        return this.restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);
    }



}
