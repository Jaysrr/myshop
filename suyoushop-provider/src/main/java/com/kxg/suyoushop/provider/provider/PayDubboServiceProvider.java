package com.kxg.suyoushop.provider.provider;

import com.kxg.suyoushop.constant.MyShopConstants;
import com.kxg.suyoushop.handler.PayHandler;
import com.kxg.suyoushop.request.GetPayTokenRequest;
import com.kxg.suyoushop.request.PayByOrderRequest;
import com.kxg.suyoushop.response.PayByOrderResponse;
import com.kxg.suyoushop.response.GetPayTokenResponse;
import com.kxg.suyoushop.service.PayDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @program: suyoushop
 * @description: 支付系统的dubbo service实现类
 * @author: Jaysrr
 * @create: 2020-03-15 15:17
 **/
@Service(version = "1.0.0")
public class PayDubboServiceProvider implements PayDubboService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private PayHandler payHandler;

    @Override
    public GetPayTokenResponse getPayToken(GetPayTokenRequest request) {
        //1.生成token并返回
        String payToken = UUID.randomUUID().toString();
        //2.并把token存 redis
        stringRedisTemplate.opsForValue().set(payToken, request.getAppId());
        GetPayTokenResponse response = new GetPayTokenResponse();
        response.setPayToken(payToken);
        return response;
    }

    @Override
    public PayByOrderResponse payByOrder(PayByOrderRequest request) {
        PayByOrderResponse payByOrderResponse = new PayByOrderResponse();
        //1.拿payToken去redis查 是不是token可以取到上次的值(appID)
        String s = stringRedisTemplate.opsForValue().get(request.getPayToken());
        if (StringUtils.isEmpty(s)) {
            payByOrderResponse = null;
        }

        //如果appId不相等 说明token错误
        if (!s.equals(request.getAppId())) {
            payByOrderResponse = null;
        }
        //如果相等就调用本地service 继续支付 返回一个支付成功的标志
        // 模拟微信支付
        if ("Wechat".equals(request.getPayType())) {
            if ("SUCCESS".equals(payHandler.weChatPay(request))) {
                payByOrderResponse.setEnd(MyShopConstants.PAY_SUCCESSED);
            }

        }
        // 模拟支付宝支付
        if ("AliPay".equals(request.getPayType())) {
            if ("SUCCESS".equals(payHandler.aliPay(request))) {
                payByOrderResponse.setEnd(MyShopConstants.PAY_SUCCESSED);
            }
        }
        return payByOrderResponse;
    }
}
