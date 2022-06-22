package com.prashant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.dto.Purchase;
import com.prashant.dto.PurchaseResponse;
import com.prashant.service.CheckOutService;



@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

	@Autowired
	private CheckOutService checkOutService;
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);
		return purchaseResponse;
	}
}
