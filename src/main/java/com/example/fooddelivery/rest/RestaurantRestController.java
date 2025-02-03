package com.example.fooddelivery.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantRestController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping
	public List<Restaurant> getRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getRestaurantById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.getRestaurantById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@GetMapping("/{id}/listmenu")
	public ResponseEntity<Object> findAllFoodsInRestaurant(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.findAllFoodsInRestaurant(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@GetMapping("/{id}/listaddress")
	public ResponseEntity<Object> findAllAddressesOfRestaurant(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.findAllAddressesOfRestaurant(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@GetMapping("/foodtype/{cuisine}")
	public ResponseEntity<Object> findAllAddressesOfRestaurant(@PathVariable String cuisine){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.findAllRestaurantsByCuisine(cuisine));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addRestaurant(@RequestBody Restaurant restaurant){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.addNewRestaurant(restaurant));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateRestaurant(@RequestBody Restaurant restaurant){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("restaurant", restaurantService.updateRestaurant(restaurant));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteRestaurant(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(restaurantService.deleteRestaurant(id)) {
				map.put("message", "Restaurant deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}

}
