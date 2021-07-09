package com.skcc.order.service;

import com.skcc.config.RestService;
import com.skcc.payment.message.PaymentEvent;
import com.skcc.product.message.ProductEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
// @XRayEnabled
public class OrderService {

	@Autowired
	private RestService<Boolean> restBoolService;

	@Value("${api.order.url}")
	private String apiGatewayUrl;

	public OrderService() {}

	public boolean editOrderProductCancel(ProductEvent productEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/orders/product/cancel"), HttpHeaders.EMPTY, productEvent, boolean.class)
				.getBody();
	}

	public boolean editOrderPaymentCancel(PaymentEvent paymentEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/orders/payment/cancel"), HttpHeaders.EMPTY, paymentEvent, boolean.class)
				.getBody();
	}

	public boolean editOrderPaymentPaid(PaymentEvent paymentEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/orders/payment/paid"), HttpHeaders.EMPTY, paymentEvent, boolean.class)
				.getBody();
	}

	public boolean editOrderPayment(PaymentEvent paymentEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/orders/payment"), HttpHeaders.EMPTY, paymentEvent, boolean.class)
				.getBody();
	}

}
