package com.skcc.account.message;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountEvent {

	private Long id;
	private String domain;
	private Long accountId;
	private AccountEventType eventType;
	private AccountPayload payload;
	private String txId;
	private LocalDateTime createdAt;
}
