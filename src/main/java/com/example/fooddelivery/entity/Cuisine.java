package com.example.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuisine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
    @ManyToOne
    @JoinColumn(name = "rid")
	private Restaurant restaurant;
    
    @ManyToOne
    @JoinColumn(name = "csid")
	private Foodtype foodtype;

    public Cuisine() {}
    
	public Cuisine(int cid, Restaurant restaurant, Foodtype foodtype) {
		super();
		this.cid = cid;
		this.restaurant = restaurant;
		this.foodtype = foodtype;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Foodtype getFoodtype() {
		return foodtype;
	}

	public void setCuisine(Foodtype foodtype) {
		this.foodtype = foodtype;
	}

	@Override
	public String toString() {
		return "Cuisine [cid=" + cid + ", restaurant=" + restaurant + ", foodtype=" + foodtype + "]";
	}
    
}
