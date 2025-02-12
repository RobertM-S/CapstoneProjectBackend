package com.example.fooddelivery.entity;

import java.util.Arrays;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	private String restaurantname;
	private String description;
	private String restaurantimage;
//	private Address address;
//	private String[] cuisine;
	
    @OneToMany(mappedBy = "restaurant")
    Set<Menu> menu;
    
    @OneToMany(mappedBy = "restaurant")
    Set<Cuisine> cuisine;
    
    @OneToMany(mappedBy = "restaurant")
    Set<Restaurantaddress> restaurantAddress;
    
    
	public Restaurant() {}

	public Restaurant(int rid, String restaurantname, String description) {
		super();
		this.rid = rid;
		this.restaurantname = restaurantname;
		this.description = description;
//		this.address = address;
//		this.cuisine = cuisine;
	}

	public int getRestaurantid() {
		return rid;
	}

	public void setRestaurantid(int rid) {
		this.rid = rid;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

//	public String[] getCuisine() {
//		return cuisine;
//	}
//
//	public void setCuisine(String[] cuisine) {
//		this.cuisine = cuisine;
//	}

	public String getRestaurantimage() {
		return restaurantimage;
	}

	public void setRestaurantimage(String restaurantimage) {
		this.restaurantimage = restaurantimage;
	}

	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", restaurantname=" + restaurantname + ", description="
				+ description + ", menu=" + menu + "]";
	}
	
}
