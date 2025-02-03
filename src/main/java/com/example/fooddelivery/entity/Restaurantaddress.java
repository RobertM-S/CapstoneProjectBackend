package com.example.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Restaurantaddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int raid;
	
    @ManyToOne
    @JoinColumn(name = "rid")
	private Restaurant restaurant;
    
    @ManyToOne
    @JoinColumn(name = "aid")
    private Address address;
	
    public Restaurantaddress() {}

	public Restaurantaddress(int raid, Restaurant restaurant, Address address) {
		super();
		this.raid = raid;
		this.restaurant = restaurant;
		this.address = address;
	}

	public int getRaid() {
		return raid;
	}

	public void setRaid(int raid) {
		this.raid = raid;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RestaurantAddress [raid=" + raid + ", restaurant=" + restaurant + ", address=" + address + "]";
	}
    
}
