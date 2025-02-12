package com.example.fooddelivery.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Basket;
import com.example.fooddelivery.entity.BasketEdit;
import com.example.fooddelivery.entity.Cuisine;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurantaddress;
import com.example.fooddelivery.entity.Useraddress;
import com.example.fooddelivery.service.AddressService;
import com.example.fooddelivery.service.BasketService;
import com.example.fooddelivery.service.CuisineService;
import com.example.fooddelivery.service.RestaurantaddressService;
import com.example.fooddelivery.service.UseraddressService;

@RestController
@RequestMapping("/baskets")
public class BasketRestController {
		
	@Autowired
	private BasketService basketService;
	
	@GetMapping
	public List<Basket> getBaskets(){
		return basketService.getAllBaskets();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addToBasket(@RequestBody Basket basket){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("basket", basketService.addNewBasket(basket));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<Object> deleteBasket(@PathVariable int uid){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("basket", basketService.deleteByUser(uid));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/edit")
	public ResponseEntity<Object> editBasket(@RequestBody BasketEdit checkout){
		System.out.println("here i am");
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("basket", basketService.editBasket(checkout));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
}