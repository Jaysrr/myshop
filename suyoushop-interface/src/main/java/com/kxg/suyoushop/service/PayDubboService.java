package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.GetPayTokenRequest;
import com.kxg.suyoushop.request.PayByOrderRequest;
import com.kxg.suyoushop.response.PayByOrderResponse;
import com.kxg.suyoushop.response.GetPayTokenResponse;

/**
 * @program: suyoushop
 * @description: 支付系统的dubbo接口
 **/
public interface PayDubboService {
    /**
     * @Description: 用于给订单系统提供token 不带关于订单的信息在请求参数里就是为了安全，
     * 因为可能存在order系统调用pay系统时，
     * 被黑客拦截 导致order系统请求携带的订单信息被截取，造成损失
     * 所以只随便从pay系统要一个随机字符串 便于下次真正请求时 带着这个token去请求就比较安全(因为在第一次请求的时候，pay系统会把这次请求放入白名单)
     * appId表示每个项目的随机的id
     */
    //因为是dubbo调用 所以token 要包装在req里
//    String getPayToken(String appId);
    GetPayTokenResponse getPayToken(GetPayTokenRequest request);


    /**
     * @Description: 确认订单，实现真正支付
     * @Param: [payToken, request]
     * @return: com.kxg.suyoushop.response.MakeSureOrderResponse
     * @Author: Jay
     */
    //因为是dubbo调用 所以token 要包装在req里
//    MakeSureOrderResponse payByOrder(String payToken, MakeSureOrderRequest request);
    PayByOrderResponse payByOrder(PayByOrderRequest request);

}
