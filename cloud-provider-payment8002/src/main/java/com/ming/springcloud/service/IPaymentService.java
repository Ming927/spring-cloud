package com.ming.springcloud.service;

import com.ming.springcloud.entity.Payment;

/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
public interface IPaymentService  {

    public Integer create(Payment payment);

    public Payment getPaymentById(Long id);

}
