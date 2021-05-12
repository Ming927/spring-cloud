package com.ming.springcloud.dao;

import com.ming.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
//@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
