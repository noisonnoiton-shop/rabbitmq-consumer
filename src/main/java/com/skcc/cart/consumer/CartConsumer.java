package com.skcc.cart.consumer;

import java.util.function.Consumer;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.cart.service.CartService;
import com.skcc.product.message.ProductEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@XRayEnabled
@Slf4j
public class CartConsumer {

  @Autowired
  private CartService cartService;

  @Bean("productSoldOut")
  public Consumer<Message<ProductEvent>> productSoldOut() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      ProductEvent productEvent = message.getPayload();
      cartService.editCartProductInactive(productEvent);
    };
  }

  @Bean("productAmountAdded")
  public Consumer<Message<ProductEvent>> productAmountAdded() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      ProductEvent productEvent = message.getPayload();
      cartService.editCartProductActive(productEvent);
    };
  }

}