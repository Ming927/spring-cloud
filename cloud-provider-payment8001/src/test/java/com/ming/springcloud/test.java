package com.ming.springcloud;

import com.ming.springcloud.service.impl.PaymentServiceImpl;
import org.junit.Test;

/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
public class test {

    @Test
    public void getPaymentById() {
        PaymentServiceImpl paymentService=new PaymentServiceImpl();
        System.out.println(paymentService.getPaymentById(21L));
    }
}
