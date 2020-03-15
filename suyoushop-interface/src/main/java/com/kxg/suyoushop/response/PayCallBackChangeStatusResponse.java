package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-14 18:29
 **/
@Data
public class PayCallBackChangeStatusResponse implements Serializable {
    private static final long serialVersionUID = -8641306170882982760L;
    private Integer end;
}
