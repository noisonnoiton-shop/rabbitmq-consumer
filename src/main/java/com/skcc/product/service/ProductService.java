package com.skcc.product.service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.skcc.config.RestService;
import com.skcc.order.message.OrderEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@XRayEnabled
public class ProductService {

	@Autowired
	private RestService<Boolean> restBoolService;

	@Value("${api.product.url}")
	private String apiGatewayUrl;

	public ProductService() {}

	public boolean editProductSubstract(OrderEvent orderEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/products/substract"), HttpHeaders.EMPTY, orderEvent, boolean.class)
				.getBody();
	}

	public boolean editProductAdd(OrderEvent orderEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/products/add"), HttpHeaders.EMPTY, orderEvent, boolean.class)
				.getBody();
	}

}
