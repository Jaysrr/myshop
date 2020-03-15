package com.kxg.suyoushop.provider.provider;

import com.kxg.suyoushop.constant.MyShopConstants;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrderService;
import com.kxg.suyoushop.request.*;
import com.kxg.suyoushop.response.*;
import com.kxg.suyoushop.service.OrderDubboService;
import com.kxg.suyoushop.service.PayDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.Kernel;
import java.util.Date;
import java.util.UUID;

/**
 * @program: suyoushop
 * @description: 订单系统dubbo接口实现类
 * @author: Jaysrr
 * @create: 2020-03-14 18:33
 **/
@Service(version = "1.0.0")
public class OrderDubboServiceProvider implements OrderDubboService {
    @Autowired
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private PayDubboService payDubboService;

    @Override
    public AddOrderResponse addOrder(AddOrderRequest request) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(request, orders);
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setStatus(MyShopConstants.NOT_PAYED_STATUS);
        Integer result = orderService.addOrder(orders);
        AddOrderResponse response = new AddOrderResponse();
        response.setEnd(result);
        return response;
    }

    @Override
    public ConfirmOrderResponse confirmOrder(ConfirmOrderRequest request) {
        //设置一个appId 并且封装起来 去pay系统调用
        String appId = UUID.randomUUID().toString();
        GetPayTokenRequest getPayTokenRequest = new GetPayTokenRequest();
        getPayTokenRequest.setAppId(appId);
        //1.获取第一次在pay系统产生的 token 并校验
        GetPayTokenResponse getPayTokenResponse = payDubboService.getPayToken(getPayTokenRequest);

        //2.拿着token正式下单
//        return payDubboService.payByOrder(payToken, request);
        PayByOrderRequest payByOrderRequest = new PayByOrderRequest();
        //设置正式下单的时候 复制前端传来的订单信息,设置订单信息
        BeanUtils.copyProperties(request,payByOrderRequest);
        //设置正式下单的时候 除了订单信息之外的两个逻辑信息
        payByOrderRequest.setPayToken(getPayTokenResponse.getPayToken());
        payByOrderRequest.setAppId(appId);

        ConfirmOrderResponse makeSureOrderResponse = new ConfirmOrderResponse();
        PayByOrderResponse payByOrderResponse = payDubboService.payByOrder(payByOrderRequest);
        //在把返回值包装回去
        BeanUtils.copyProperties(payByOrderResponse, makeSureOrderResponse);
        return makeSureOrderResponse;
    }


    @Override
    public PayCallBackChangeStatusResponse PayCallBackChangeStatus(PayCallBackChangeStatusRequest request) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(request, orders);
        orders.setStatus(request.getStatus());
        orders.setId(request.getOrderId());
        //如果支付成功 则设置payCode否则不设置
        if (MyShopConstants.PAY_SUCCESSED.equals(request.getPayCode())) {
            orders.setPayCode(request.getPayCode());
        }
        //并且把它更新到数据库
        PayCallBackChangeStatusResponse response = new PayCallBackChangeStatusResponse();
        response.setEnd(orderService.payCallBackChangeStatus(orders));
        return response;
    }
}
