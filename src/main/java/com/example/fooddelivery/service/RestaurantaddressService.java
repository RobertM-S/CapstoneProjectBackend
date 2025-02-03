package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Restaurantaddress;
import com.example.fooddelivery.repo.AddressRepo;
import com.example.fooddelivery.repo.RestaurantaddressRepo;


@Service
public class RestaurantaddressService {
	
	@Autowired
	private RestaurantaddressRepo restaurantAddressrepo;
	
	public List<Restaurantaddress> getAllRestaurantAddresses(){
		return restaurantAddressrepo.findAll();
	}
	
}
