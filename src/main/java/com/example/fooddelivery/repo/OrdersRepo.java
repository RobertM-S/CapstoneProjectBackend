package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
