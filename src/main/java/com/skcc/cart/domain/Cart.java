package com.skcc.cart.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

	private Long id;
	private Long accountId;
	private Long productId;
	private String productActive;
	private Long productQuantity;
	private CartProduct productInfo;
	private LocalDateTime createdAt;

}
