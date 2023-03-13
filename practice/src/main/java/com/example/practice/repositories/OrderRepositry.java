package com.example.practice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.practice.model.Order;

public interface OrderRepositry  extends CrudRepository<Order, Integer> {
	
	List<Order> findByProviderId(String providerId);
	
	List<Order> findByUserId(String userId);
	
	List<Order> findByOrderStatus(String orderStatus);
}
