package com.skcc.order.message;

public enum OrderEventType {
	OrderCreated
	,OrderCanceled
	,OrderPaymentIdSet
	,OrderPaid
	,OrderCreateFailed
	,OrderCancelFailed
	,OrderPaymentIdSetFailed
	,OrderPayFailed
}
