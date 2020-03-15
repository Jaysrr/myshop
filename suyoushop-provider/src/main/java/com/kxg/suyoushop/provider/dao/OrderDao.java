package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.OrdersMapper;
import com.kxg.suyoushop.provider.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: suyoushop
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-14 19:21
 **/
@Repository
public class OrderDao {
    @Autowired
    private OrdersMapper ordersMapper;
    public Integer addOrder(Orders orders) {
        return ordersMapper.insert(orders);
    }

    public Integer payCallBackChangeStatus(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }
}
