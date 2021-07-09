package com.skcc.account.consumer;

import java.util.function.Consumer;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.account.message.AccountEvent;
import com.skcc.account.service.AccountBankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@XRayEnabled
@Slf4j
public class AccountConsumer {

  @Autowired
  private AccountBankService accountBankService;

  @Bean("accountCreated")
  public Consumer<Message<AccountEvent>> accountCreated() {
    return (message) -> {
      log.info("RECV {}", message.getPayload().toString());
      AccountEvent accountEvent = message.getPayload();
      accountBankService.createAccountBank(accountEvent);
    };
  }

}