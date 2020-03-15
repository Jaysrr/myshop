package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-15 15:45
 **/
@Data
public class PayByOrderResponse implements Serializable {
    private static final long serialVersionUID = 2359667566171666647L;
    private Short end;
}
