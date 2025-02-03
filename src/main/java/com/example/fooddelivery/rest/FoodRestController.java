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
import com.example.fooddelivery.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodRestController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public List<Food> getFoods(){
		return foodService.getAllFoods();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getFoodById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("food", foodService.getFoodById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addFood(@RequestBody Food food){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("food", foodService.addNewFood(food));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateFood(@RequestBody Food food){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("food", foodService.updateFood(food));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteFood(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(foodService.deleteFood(id)) {
				map.put("message", "Food deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}

}
