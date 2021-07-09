package com.skcc.account.service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.account.message.AccountEvent;
import com.skcc.config.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
// @XRayEnabled
public class AccountBankService {

	@Autowired
	private RestService<Boolean> restBoolService;

	@Value("${api.account.url}")
	private String apiGatewayUrl;

	public AccountBankService() {}

	public boolean createAccountBank(AccountEvent accountEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/accountbanks"), HttpHeaders.EMPTY, accountEvent, boolean.class)
				.getBody();
	}

}
