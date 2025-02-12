package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {

	  @Query(value = "select orderblock from orders order by orderblock desc limit 1;", nativeQuery = true)
	  int getLastOrderblock();
	
}
