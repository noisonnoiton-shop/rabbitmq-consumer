package com.skcc.order.consumer;

import java.util.function.Consumer;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.order.service.OrderService;
import com.skcc.payment.message.PaymentEvent;
import com.skcc.product.message.ProductEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@XRayEnabled
@Slf4j
public class OrderConsumer {

  @Autowired
  private OrderService orderService;

  @Bean("productAmountSubtractFailed")
  public Consumer<Message<ProductEvent>> productAmountSubtractFailed() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      ProductEvent productEvent = message.getPayload();
      orderService.editOrderProductCancel(productEvent);
    };
  }

  @Bean("paymentCreateFailed")
  public Consumer<Message<PaymentEvent>> paymentCreateFailed() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      PaymentEvent paymentEvent = message.getPayload();
      orderService.editOrderPaymentCancel(paymentEvent);
    };
  }

  @Bean("paymentPaid")
  public Consumer<Message<PaymentEvent>> paymentPaid() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      PaymentEvent paymentEvent = message.getPayload();
      orderService.editOrderPaymentPaid(paymentEvent);
    };
  }

  @Bean("paymentCreated")
  public Consumer<Message<PaymentEvent>> paymentCreated() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      PaymentEvent paymentEvent = message.getPayload();
      orderService.editOrderPayment(paymentEvent);
    };
  }

}