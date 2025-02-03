package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
