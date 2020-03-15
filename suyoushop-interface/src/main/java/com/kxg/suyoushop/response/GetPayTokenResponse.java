package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description: 获取第一次调用pay系统返回的token的响应类
 * @author: Jaysrr
 * @create: 2020-03-15 15:51
 **/
@Data
public class GetPayTokenResponse implements Serializable {
    private static final long serialVersionUID = -5583579313085492613L;
    private String payToken;
}
