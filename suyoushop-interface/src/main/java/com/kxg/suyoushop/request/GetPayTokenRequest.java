package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description: 通过appId去在第一次请求pay系统的时候获取token
 * @author: Jaysrr
 * @create: 2020-03-15 15:50
 **/
@Data
public class GetPayTokenRequest implements Serializable {
    private static final long serialVersionUID = -5890860067071711201L;
    private String appId;
}
