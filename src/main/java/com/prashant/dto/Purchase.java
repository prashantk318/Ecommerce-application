package com.prashant.dto;

import java.util.Set;

import com.prashant.entity.Address;
import com.prashant.entity.Customer;
import com.prashant.entity.Order;
import com.prashant.entity.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
	
	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem>orderItems;
	 
	

}
