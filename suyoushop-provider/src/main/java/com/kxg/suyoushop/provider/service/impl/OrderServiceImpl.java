package com.kxg.suyoushop.provider.service.impl;

import com.kxg.suyoushop.provider.dao.OrderDao;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: suyoushop
 * @description: 本地订单的service'
 * @author: Jaysrr
 * @create: 2020-03-14 19:19
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Integer addOrder(Orders orders) {
        return orderDao.addOrder(orders);
    }


    @Override
    public Integer payCallBackChangeStatus(Orders orders) {
        return orderDao.payCallBackChangeStatus(orders);
    }
}
