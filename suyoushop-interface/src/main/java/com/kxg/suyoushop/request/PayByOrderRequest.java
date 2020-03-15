package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description: 含有appID:表示每个项目的id
 * @author: Jaysrr
 * @create: 2020-03-15 15:44
 **/
@Data
public class PayByOrderRequest implements Serializable {
    private static final long serialVersionUID = -3675567375385717185L;

    private Double totalPriece;

    private Long userId;

    private Long shopId;

    private Long orderId;

    //表示项目的id
    private String appId;

    private String payToken;

    private String payType;
}
