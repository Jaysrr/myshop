package com.kxg.suyoushop.consumer.controller.order;

import com.kxg.suyoushop.constant.MyShopConstants;
import com.kxg.suyoushop.consumer.common.SzpJsonResult;
import com.kxg.suyoushop.consumer.handler.CheckHandler;
import com.kxg.suyoushop.request.*;
import com.kxg.suyoushop.response.AddOrderResponse;
import com.kxg.suyoushop.response.ConfirmOrderResponse;
 import com.kxg.suyoushop.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: suyoushop
 * @description: 订单系统
 * @author: Jaysrr
 * @create: 2020-03-12 16:55
 **/
@RestController
@RequestMapping("order")
public class OrderController {
    @Reference(version = "1.0.0")
    private OrderDubboService orderDubboService;


    @Autowired
    private CheckHandler checkHandler;


    //添加订单（还没调用pay 没付钱）
    public SzpJsonResult<AddOrderResponse> addOrder(@RequestHeader("token") String token, @RequestBody @Validated AddOrderRequest request) {
        if (checkHandler.checkSSOToken(token)) {
            return SzpJsonResult.ok(orderDubboService.addOrder(request));
        }
        return SzpJsonResult.errorTokenMsg(MyShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    //确认订单（要去调用pay系统）
    public SzpJsonResult<ConfirmOrderResponse> makeSureOrder(@RequestHeader("payToken") String payToken, @RequestBody @Validated ConfirmOrderRequest request) {
        if (checkHandler.checkPayToken(payToken, request.getOrderId())) {
            return SzpJsonResult.ok(orderDubboService.confirmOrder(request));
        }
        return SzpJsonResult.errorTokenMsg(MyShopConstants.PAY_TOKEN_IS_NOT_RIGHT);
    }

    //更新订单
    //删除订单

    /**
     * @Description: 这是调用支付系统，支付成功后回调的函数：
     * 1.若支付成功 修改支付状态为支付成功
     * 2.若支付失败，修改支付状态为取消支付
     * 返回值可以是有http状态码：因为存在支付成功 但是订单系统挂了的情况，那么为了安全，支付系统可以按照这个返回值 对这次支付过程 进行回滚。
     * 返回值也可以没有，因为订单系统可以只管付钱
     * @Author: Jay
     * @Date: 2020/3/14
     */
//    public SzpJsonResult<PayCallBackChangeStatusResponse> PayCallBackChangeStatus(@RequestHeader("token") String payToken, @RequestBody @Validated PayCallBackChangeStatusRequest request) {
    public void PayCallBackChangeStatus(@RequestHeader("token") String payToken, @RequestBody @Validated PayCallBackChangeStatusRequest request) {
        //校验token
        if (checkHandler.checkPayToken(payToken, request.getOrderId())) {
            orderDubboService.PayCallBackChangeStatus(request);
        }
    }


}
