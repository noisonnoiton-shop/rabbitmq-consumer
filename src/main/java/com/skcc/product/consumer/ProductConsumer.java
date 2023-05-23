package com.skcc.product.consumer;

import java.util.function.Consumer;

// import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.order.message.OrderEvent;
import com.skcc.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
// @XRayEnabled
@Slf4j
public class ProductConsumer {

  @Autowired
  private ProductService productService;

  @Bean("orderProductCanceled")
  public Consumer<Message<OrderEvent>> orderProductCanceled() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      OrderEvent orderEvent = message.getPayload();
      productService.editProductAdd(orderEvent);
    };
  }

  @Bean("orderProductCreated")
  public Consumer<Message<OrderEvent>> orderProductCreated() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      OrderEvent orderEvent = message.getPayload();
      productService.editProductSubstract(orderEvent);
    };
  }
}