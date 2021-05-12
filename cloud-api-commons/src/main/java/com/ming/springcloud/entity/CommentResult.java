package com.ming.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yzm
 * @date: 2021/4/26
 * @Description:
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code, String message) {
        this(code,message,null);
    }
}
