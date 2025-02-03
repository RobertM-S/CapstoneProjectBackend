package com.example.fooddelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Restaurantaddress;
import com.example.fooddelivery.entity.Useraddress;
import com.example.fooddelivery.service.AddressService;
import com.example.fooddelivery.service.RestaurantaddressService;
import com.example.fooddelivery.service.UseraddressService;

@RestController
@RequestMapping("/useraddresses")
public class UseraddressRestController {
	
	@Autowired
	private UseraddressService userAddressService;
	
	@GetMapping
	public List<Useraddress> getUserAddresses(){
		return userAddressService.getAllUserAddresses();
	}

}
