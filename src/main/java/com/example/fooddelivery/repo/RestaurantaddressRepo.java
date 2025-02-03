package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Restaurantaddress;

public interface RestaurantaddressRepo extends JpaRepository<Restaurantaddress, Integer> {

}
