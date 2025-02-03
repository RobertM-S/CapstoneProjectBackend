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
import com.example.fooddelivery.entity.User;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getusers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("user", userService.getUserById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("user", userService.addNewUser(user));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("user", userService.updateUser(user));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(userService.deleteUser(id)) {
				map.put("message", "user deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}
	
	@GetMapping("/{id}/listaddress")
	public ResponseEntity<Object> findAllAddressesOfUser(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("user", userService.findAllAddressesOfUser(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}

}
