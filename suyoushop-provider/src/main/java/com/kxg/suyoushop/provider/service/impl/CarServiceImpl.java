package com.kxg.suyoushop.provider.service.impl;

import com.kxg.suyoushop.dto.FindCarByUserIdDto;
import com.kxg.suyoushop.provider.dao.CarDao;
import com.kxg.suyoushop.provider.pojo.Cars;
import com.kxg.suyoushop.provider.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: suyoushop
 * @description: 购物车本地service实现类 传的参数都是落库需要的参数 那么这个service和dubboService的区别就是
 * 这个service是为数据库取出来的东西做操作(比如分页，，事务之类的)
 * 而dubboService主要是参数的封装传递到上层的controller和解封传递到下层的本地service
 * @author: Jaysrr
 * @create: 2020-03-11 00:03
 **/
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public Integer addGoodsToCar(Cars cars) {
        return carDao.addGoodsToCar(cars);
    }

    @Override
    public Integer updateCar(Cars cars) {
        return carDao.updateCar(cars);
    }

    @Override
    public Integer deleteGoodsById(Long goodsId) {
        return carDao.deleteGoodsById(goodsId);
    }

    @Override
    public FindCarByUserIdDto findCarByUserId(Long id, Integer pageSize, Integer pageNumber) {
        return null;
    }


}
