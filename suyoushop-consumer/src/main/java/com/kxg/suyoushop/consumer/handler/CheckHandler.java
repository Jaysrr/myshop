package com.kxg.suyoushop.consumer.handler;

import org.springframework.stereotype.Component;

/**
 * @program: suyoushop
 * @description: 用来处理请求信息的公共类 如处理token等
 * @author: Jaysrr
 * @create: 2020-03-11 14:36
 **/
public interface CheckHandler {
    /**
     * @Description: 检验用户 单点登录后的token
     * @Param: [token]
     * @return: java.lang.Boolean
     * @Author: Jay
     * @Date: 2020/3/11
     */
    Boolean checkSSOToken(String token);

    /**
     * @Description: 检验用户 是否支付的后的token
     * @Param: [token]
     * @return: java.lang.Boolean
     * @Author: Jay
     */
    Boolean checkPayToken(String token,Long orderId);

}
