package com.skcc.cart.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CartEvent {

	private Long id;
	private String domain;
	private long cartId;
	private CartEventType eventType;
	private CartPayload payload;
	private String txId;
	private String createdAt;
}
