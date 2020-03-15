package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-15 14:30
 **/
@Data
public class ConfirmOrderRequest implements Serializable {
    private static final long serialVersionUID = 7296007588233763463L;

    private Double totalPriece;

    private Long userId;

    private Long shopId;

    private Long orderId;
}
