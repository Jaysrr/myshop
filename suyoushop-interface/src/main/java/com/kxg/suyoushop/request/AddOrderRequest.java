package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-14 18:21
 **/
@Data
public class AddOrderRequest implements Serializable {
    private static final long serialVersionUID = 2585281107507791496L;

    private Long carId;

//    private Short status;//因为添加订单时 前端并不知道是否支付 所以不需要这个字段

    private Double totalPriece;

    private Long userId;

    private Long shopId;
}
