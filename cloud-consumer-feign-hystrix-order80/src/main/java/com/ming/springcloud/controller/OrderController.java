package com.ming.springcloud.controller;

import com.ming.springcloud.service.OrderFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yzm
 * @date: 2021/5/1
 * @Description:
 * @Version: 1.0
 **/
@RestController
@Log4j2
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {

    @Resource
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        return orderFeignHystrixService.paymentInfo_ok(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "8000")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        return orderFeignHystrixService.paymentInfo_timeout(id);
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName() + "paymentInfo_timeout,id: " + id +"\t" + "80备胎来了！！！！";
    }

    public String payment_Global_FallbackMethod(){
        return "全局报错处理！！！";
    }

}
