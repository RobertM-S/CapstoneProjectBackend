package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.repo.FoodRepo;
import com.example.fooddelivery.repo.RestaurantRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepo restaurantrepo;
	
	public long getTotalRestaurantCount() {
		return restaurantrepo.count();
	}
	
	public List<Restaurant> getAllRestaurants(){
		return restaurantrepo.findAll();
	}
	
	public Restaurant addNewRestaurant(Restaurant restaurant) {
		if(restaurantrepo.existsById(restaurant.getRestaurantid())) {
			throw new EntityExistsException("Cannot add "+restaurant.getRestaurantid()+" already exists");
		}
		return restaurantrepo.save(restaurant);
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant){
		if(!restaurantrepo.existsById(restaurant.getRestaurantid()))
			throw new EntityNotFoundException("cannot update "+restaurant.getRestaurantid()+" does not exist");
		return restaurantrepo.save(restaurant);
	}
	
	public boolean deleteRestaurant(int id){
		if(!restaurantrepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		restaurantrepo.deleteById(id);
		return true;
	}
	
	public Restaurant getRestaurantById(int id){
		if(!restaurantrepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return restaurantrepo.findById(id).get();
	}
	
	public List<Food> findAllFoodsInRestaurant(int rid) {
		return restaurantrepo.findAllFoodsInRestaurant(rid);
	}
	
	public List<Address> findAllAddressesOfRestaurant(int rid) {
		return restaurantrepo.findAllAddressesOfRestaurant(rid);
	}
	
	public List<Restaurant> findAllRestaurantsByCuisine(String cuisine) {
		return restaurantrepo.findAllRestaurantsByCuisine(cuisine);
	}
	
}
