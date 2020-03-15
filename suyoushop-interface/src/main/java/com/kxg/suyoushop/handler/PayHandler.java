package com.kxg.suyoushop.handler;

public interface PayHandler {
    String weChatPay(Object payInfo);
    String aliPay(Object payInfo);
}
