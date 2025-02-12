package com.example.fooddelivery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.fooddelivery.entity.Address;
import com.example.fooddelivery.entity.Food;
import com.example.fooddelivery.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	  @Query(value = "select f.fid, f.foodname, f.description, menu.price, menu.image, menu.mid from food f join menu on menu.fid = f.fid join restaurant on restaurant.rid = menu.rid where restaurant.rid = ?;", nativeQuery = true)
	  List<Food> findAllFoodsInRestaurant(int restaurantId);
	  	
	  @Query(value = "select a.aid, a.city, a.postcode, a.street, a.number from address a join restaurantaddress on restaurantaddress.aid = a.aid join restaurant on restaurant.rid = restaurantaddress.rid where restaurant.rid = ?;", nativeQuery = true)
	  List<Address> findAllAddressesOfRestaurant(int restaurantId);
	  
	  @Query(value = "select restaurant.rid, restaurant.restaurantname, restaurant.description restaurant.restaurantimage from foodtype f join cuisine on cuisine.csid = f.csid join restaurant on restaurant.rid = cuisine.rid where f.foodtype = ?;", nativeQuery = true)
	  List<Restaurant> findAllRestaurantsByCuisine(String cuisine);
	  
	  @Query(value = "select restaurant.rid, restaurant.restaurantname, restaurant.description, restaurant.restaurantimage from restaurant restaurant join restaurantaddress on restaurantaddress.rid = restaurant.rid join address on address.aid = restaurantaddress.aid and address.postcode like ?% group by restaurant.rid;", nativeQuery = true)
	  List<Restaurant> findAllRestaurantsByPostcode(String postcode);
	  
	  @Query(value = "select restaurant.rid, restaurant.restaurantname, restaurant.description, restaurant.restaurantimage, foodtype.foodtype from restaurant restaurant  join restaurantaddress on restaurantaddress.rid = restaurant.rid  join address on address.aid = restaurantaddress.aid  join cuisine on cuisine.rid = restaurant.rid join foodtype on foodtype.csid = cuisine.csid where address.postcode like ?% and (foodtype.foodtype like ?% or foodtype.foodtype like %?);", nativeQuery = true)
	  List<Restaurant> findAllRestaurantsByPostcodeAndFoodtype(String postcode, String foodtype, String foodtype2);
	  
}
