package com.ming.springcloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yzm
 * @date: 2021/4/28
 * @Description:
 * @Version: 1.0
 **/
@RestController
@Log4j2
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String getServerPort(){
        return "spring cloud with consul: " + serverPort + "\t " + UUID.randomUUID().toString();
    }

}
