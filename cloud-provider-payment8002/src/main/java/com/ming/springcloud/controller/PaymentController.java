package com.ming.springcloud.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ming.springcloud.entity.CommentResult;
import com.ming.springcloud.entity.Payment;
import com.ming.springcloud.service.IPaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
@RestController
@Log4j2
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment) {
        Integer code = paymentService.create(payment);
        log.info("*********插入结果： " + code );
        if ( code > 0 ){
            return new CommentResult(200,"插入成功！！! serverPort: " + serverPort, code );
        }else{
            return new CommentResult(400,"插入失败！！！", null );
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果： " + payment );
        if (ObjectUtil.isNotEmpty(payment)){
            return new CommentResult(200,"查询成功！！! serverPort: " + serverPort, payment);
        }else{
            return new CommentResult(400,"查询失败！！！id: "+id, null );
        }
    }

    @GetMapping(value = "/payment/get")
    public CommentResult getPayment() {
        Payment payment = paymentService.getPaymentById(21L);
        log.info("*********查询结果： " + payment );
        if (ObjectUtil.isNotEmpty(payment)){
            return new CommentResult(200,"查询成功！！! serverPort: " + serverPort, payment);
        }else{
            return new CommentResult(400,"查询失败！！！id: "+21, null );
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("####### service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                    + instance.getPort() +"\t" + instance.getUri() );
        }
        return this.discoveryClient;
    }
}
