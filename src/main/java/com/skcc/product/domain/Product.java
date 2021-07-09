package com.skcc.product.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Long id;
	private String name;
	private Long categoryId;
	private String active;
	private Long originalPrice;
	private Long salePercentage;
	private Long salePrice;
	private Long resultPrice;
	private Long amount;
	private String img;
	private LocalDateTime createdAt;

	private String categoryName;
}
