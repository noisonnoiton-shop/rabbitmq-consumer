package com.skcc.order.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private Long id;
	private Long accountId;
	private Long paymentId;
	private String productActive;
	private Long productQuantity;
	private OrderAccount accountInfo;
	private List<OrderProduct> productsInfo;
	private OrderPayment paymentInfo;
	private String paid;
	private String status;
	private LocalDateTime createdAt;
}
