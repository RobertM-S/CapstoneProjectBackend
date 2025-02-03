package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	  @Query(value = "select f.fid, f.foodname, f.description from food f join menu on menu.fid = f.fid join restaurant on restaurant.rid = menu.rid where restaurant.rid = ?;", nativeQuery = true)
	  List<Food> findAllFoodsInRestaurant(int restaurantId);
	
	  @Query(value = "select a.aid, a.city, a.postcode, a.street, a.number from address a join restaurantaddress on restaurantaddress.aid = a.aid join restaurant on restaurant.rid = restaurantaddress.rid where restaurant.rid = ?;", nativeQuery = true)
	  List<Address> findAllAddressesOfRestaurant(int restaurantId);
	  
	  @Query(value = "select restaurant.rid, restaurant.restaurantname, restaurant.description from foodtype f join cuisine on cuisine.csid = f.csid join restaurant on restaurant.rid = cuisine.rid where f.foodtype = ?;", nativeQuery = true)
	  List<Restaurant> findAllRestaurantsByCuisine(String cuisine);
	  
}
