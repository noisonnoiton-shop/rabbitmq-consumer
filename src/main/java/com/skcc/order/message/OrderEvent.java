package com.skcc.order.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderEvent {

	private Long id;
	private String domain;
	private long orderId;
	private OrderEventType eventType;
	private OrderPayload payload;
	private String txId;
	private String createdAt;
}
