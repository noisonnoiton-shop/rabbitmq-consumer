package com.skcc.payment.service;

// import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.config.RestService;
import com.skcc.order.message.OrderEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
// @XRayEnabled
public class PaymentService {

	@Autowired
	private RestService<Boolean> restBoolService;

	@Value("${api.payment.url}")
	private String apiGatewayUrl;

	public PaymentService() {}

	public boolean createPayment(OrderEvent orderEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/payments"), HttpHeaders.EMPTY, orderEvent, boolean.class)
				.getBody();
	}

	public boolean editPaymentCancel(OrderEvent orderEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/payments/cancel"), HttpHeaders.EMPTY, orderEvent, boolean.class)
				.getBody();
	}
}
