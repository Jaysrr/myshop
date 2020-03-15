package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: suyoushop
 * @description: 支付系统回调去更新订单系统的订单状态的请求类
 * @author: Jaysrr
 * @create: 2020-03-14 18:27
 **/
@Data
public class PayCallBackChangeStatusRequest implements Serializable {
    private static final long serialVersionUID = 4235491782000502168L;

    private Long orderId;

    private Short status;

    private String payCode;
}
