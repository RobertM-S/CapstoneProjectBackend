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

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressRestController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public List<Address> getAddresses(){
		return addressService.getAllAddresses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getAddressById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("address", addressService.getAddressById(id));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> addAddress(@RequestBody Address address){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("address", addressService.addNewAddress(address));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateAddress(@RequestBody Address address){
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("address", addressService.updateAddress(address));
			return ResponseEntity.ok(map);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(map);
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(addressService.deleteAddress(id)) {
				map.put("message", "Address deleted successfully");
				return ResponseEntity.ok(map);
			}
		}
		catch (RuntimeException e){
			map.put("error",e.getMessage());
		}
		return ResponseEntity.badRequest().body(map);
	}
	
}
