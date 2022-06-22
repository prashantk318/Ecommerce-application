package com.prashant.service;

import com.prashant.dto.Purchase;
import com.prashant.dto.PurchaseResponse;

public interface CheckOutService {
	PurchaseResponse placeOrder(Purchase purchase);

}
