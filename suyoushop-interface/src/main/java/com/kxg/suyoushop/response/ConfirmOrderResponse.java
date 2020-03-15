package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-15 14:31
 **/
@Data
public class ConfirmOrderResponse implements Serializable {
    private static final long serialVersionUID = 1158055824737326255L;
    private Integer end;
}
