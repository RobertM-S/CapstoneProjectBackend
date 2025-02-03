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
import com.example.fooddelivery.entity.Foodtype;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.FoodtypeService;

@RestController
@RequestMapping("/foodtypes")
public class FoodtypeRestController {
	
	@Autowired
	private FoodtypeService foodtypeService;
	
	@GetMapping
	public List<Foodtype> getFoodtypes(){
		return foodtypeService.getAllFoodtypes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getFoodtypeById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("foodtype", foodtypeService.getFoodtypeById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addFoodtype(@RequestBody Foodtype foodtype){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("foodtype", foodtypeService.addNewFoodtype(foodtype));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateFoodtype(@RequestBody Foodtype foodtype){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("foodtype", foodtypeService.updateFoodtype(foodtype));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteFoodtype(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(foodtypeService.deleteFoodtype(id)) {
				map.put("message", "Foodtype deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}

}
