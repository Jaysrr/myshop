package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.*;
import com.kxg.suyoushop.response.*;

/**
 * @Description: 订单的dubboService接口
 */
public interface OrderDubboService {
    //添加订单
    AddOrderResponse addOrder (AddOrderRequest request);
        //更新订单 待完成
//    UpdateOrderResponse updateOrder( UpdateOrderRequest request);
    //删除订单 待完成
//    DeleteOrderResponse deleteOrderById(DeleteOrderRequest request);

    /**
     * @Description: 确认订单 首先需要调用pay系统的方法 为了保证安全 去获取token 表面是在pay系统的白名单呢哦
     * 然后才是真正的下单，调用pay系统的下单(支付)相关的方法
     * @Param: [request]
     * @return: com.kxg.suyoushop.response.MakeSureOrderResponse
     * @Author: Jay
     * @Date: 2020/3/15
     */
    ConfirmOrderResponse confirmOrder(ConfirmOrderRequest request);


    /**
     * @Description: 这是调用支付系统，支付成功后回调的函数：
     * 1.若支付成功 修改支付状态为支付成功
     * 2.若支付失败，修改支付状态为取消支付
     * 返回值可以是有状态码：因为存在支付成功 但是订单系统挂了的情况，那么为了安全，支付系统可以按照这个返回值 对这次支付过程 进行回滚。
     * 返回值也可以没有，因为订单系统可以只管付钱
     */
    PayCallBackChangeStatusResponse PayCallBackChangeStatus(PayCallBackChangeStatusRequest request);
}
