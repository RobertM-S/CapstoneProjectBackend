package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Cuisine;
import com.example.fooddelivery.entity.Restaurantaddress;
import com.example.fooddelivery.entity.Useraddress;

public interface CuisineRepo extends JpaRepository<Cuisine, Integer> {

}
