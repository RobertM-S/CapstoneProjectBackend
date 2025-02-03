package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Foodtype;

public interface FoodtypeRepo extends JpaRepository<Foodtype, Integer> {

}
