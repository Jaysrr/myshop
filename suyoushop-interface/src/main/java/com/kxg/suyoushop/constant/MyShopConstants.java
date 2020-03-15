package com.kxg.suyoushop.constant;

/**
 * @program: suyoushop
 * @description: 用于维护后期项目中使用到的常量 的类
 * @author: Jaysrr
 * @create: 2020-03-11 15:23
 **/
public final class MyShopConstants {
    private MyShopConstants() {
    }

    public static final String TOKEN_IS_NOT_RIGHT = "当前token错误,请检查token是否正确，或者过期";
    public static final String PAY_TOKEN_IS_NOT_RIGHT = "当前payToken错误,请检查payToken是否正确，或者过期";

    public static final Short NOT_PAYED_STATUS = 0;

    /**
     * 支付成功
     */
    public final static Short PAY_SUCCESSED = 1;
    /**
     * 放弃支付
     */
    public final static Short GIVE_UP_PAY = 2;

}
