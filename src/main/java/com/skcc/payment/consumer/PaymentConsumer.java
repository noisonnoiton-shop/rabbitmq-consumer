package com.skcc.payment.consumer;

import java.util.function.Consumer;

// import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.order.message.OrderEvent;
import com.skcc.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
// @XRayEnabled
@Slf4j
public class PaymentConsumer {

  @Autowired
  private PaymentService paymentService;

  @Bean("orderPaymentCanceled")
  public Consumer<Message<OrderEvent>> orderPaymentCanceled() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      OrderEvent orderEvent = message.getPayload();
      paymentService.editPaymentCancel(orderEvent);
    };
  }

  @Bean("orderPaymentCreated")
  public Consumer<Message<OrderEvent>> orderPaymentCreated() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      OrderEvent orderEvent = message.getPayload();
      paymentService.createPayment(orderEvent);
    };
  }
}