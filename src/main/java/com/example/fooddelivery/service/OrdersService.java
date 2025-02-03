package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Foodtype;
import com.example.fooddelivery.entity.Orders;
import com.example.fooddelivery.repo.FoodRepo;
import com.example.fooddelivery.repo.FoodtypeRepo;
import com.example.fooddelivery.repo.OrdersRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepo ordersrepo;
	
	public long getTotalOrdersCount() {
		return ordersrepo.count();
	}
	
	public List<Orders> getAllOrderss(){
		return ordersrepo.findAll();
	}
	
	public Orders addNewOrders(Orders orders) {
		if(ordersrepo.existsById(orders.getOid())) {
			throw new EntityExistsException("Cannot add "+orders.getOid()+" already exists");
		}
		return ordersrepo.save(orders);
	}
	
	public Orders updateOrders(Orders orders){
		if(!ordersrepo.existsById(orders.getOid()))
			throw new EntityNotFoundException("cannot update "+orders.getOid()+" does not exist");
		return ordersrepo.save(orders);
	}
	
	public boolean deleteOrders(int id){
		if(!ordersrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		ordersrepo.deleteById(id);
		return true;
	}
	
	public Orders getOrdersById(int id){
		if(!ordersrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return ordersrepo.findById(id).get();
	}
	
}
