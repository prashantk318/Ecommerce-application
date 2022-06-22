package com.prashant.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.Dao.CustomerRepository;
import com.prashant.dto.Purchase;
import com.prashant.dto.PurchaseResponse;
import com.prashant.entity.Customer;
import com.prashant.entity.Order;
import com.prashant.entity.OrderItem;

@Service
public class CheckOutServiceImpl implements CheckOutService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		
		//retrieve the order info from dto
		Order order = purchase.getOrder();
		
		//generate tracking number
		String orderTrackingNumber = orderTrackingNumber();
		
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with orderItem
		Set<OrderItem>orderItems = purchase.getOrderItems();
		orderItems.forEach(item ->order.add(item));
	
		
		//populate order with billingAddress and shippingAddress
		
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		//populate customer with order
		
		Customer customer = purchase.getCustomer();
		
		customer.add(order);
		//save to the database
		customerRepository.save(customer);
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String orderTrackingNumber() {
		// TODO Auto-generated method stub
		
		// generate a random UUID number(UUID version -4)
		
		return UUID.randomUUID().toString();
	}
	

}
