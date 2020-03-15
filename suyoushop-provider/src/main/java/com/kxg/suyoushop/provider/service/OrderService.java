package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.request.AddOrderRequest;
import com.kxg.suyoushop.request.PayCallBackChangeStatusRequest;
import com.kxg.suyoushop.response.AddOrderResponse;
import com.kxg.suyoushop.response.PayCallBackChangeStatusResponse;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-14 19:11
 **/
public interface OrderService {
    Integer addOrder (Orders orders);
//
//    UpdateCarResponse updateCar(CarsRequest request);
//
//    DeleteGoodsResponse deleteGoodsById(DeleteGoodRequest request);

    Integer payCallBackChangeStatus(Orders orders);
}
