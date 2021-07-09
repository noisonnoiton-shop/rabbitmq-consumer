package com.skcc.cart.service;

import com.skcc.config.RestService;
import com.skcc.product.message.ProductEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
// @XRayEnabled
public class CartService {

	@Autowired
	private RestService<Boolean> restBoolService;

	@Value("${api.cart.url}")
	private String apiGatewayUrl;

	public CartService() {}

	public boolean editCartProductInactive(ProductEvent productEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/carts/product/inactive"), HttpHeaders.EMPTY, productEvent, boolean.class)
				.getBody();
	}

	public boolean editCartProductActive(ProductEvent productEvent) {
		return restBoolService
				.post(String.format("%s%s", apiGatewayUrl, "/v1/carts/product/active"), HttpHeaders.EMPTY, productEvent, boolean.class)
				.getBody();
	}

}
