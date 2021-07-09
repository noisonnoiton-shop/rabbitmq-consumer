package com.skcc.payment.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	private Long id;
	private Long accountId;
	private Long orderId;
	private String paymentMethod;
	private String paymentDetail1;
	private String paymentDetail2;
	private String paymentDetail3;
	private Long price;
	private String paid;
	private String active;
	private LocalDateTime createdAt;
}
