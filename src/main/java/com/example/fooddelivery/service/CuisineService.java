package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Cuisine;
import com.example.fooddelivery.entity.Restaurantaddress;
import com.example.fooddelivery.entity.Useraddress;
import com.example.fooddelivery.repo.AddressRepo;
import com.example.fooddelivery.repo.CuisineRepo;
import com.example.fooddelivery.repo.RestaurantaddressRepo;
import com.example.fooddelivery.repo.UseraddressRepo;


@Service
public class CuisineService {
	
	@Autowired
	private CuisineRepo cuisinerepo;
	
	public List<Cuisine> getAllCuisines(){
		return cuisinerepo.findAll();
	}
	
}
