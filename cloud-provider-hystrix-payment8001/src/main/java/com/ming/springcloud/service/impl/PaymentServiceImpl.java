package com.ming.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.ming.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yzm
 * @date: 2021/5/1
 * @Description:
 * @Version: 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok,id: " + id + "\t" + "哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 5;
//        int num=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeout,id: " + id + "\t" + "哈哈";
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeout,id: " + id + "\t" + "8001备胎来了！！！！";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })

    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("###### id 不能为负数！！！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "###### id 不能为负数！！！ id: " + id;
    }
}
