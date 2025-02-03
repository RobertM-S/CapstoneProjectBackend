package com.example.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid")
	private int menuid;
	
    @ManyToOne
    @JoinColumn(name = "fid")
	private Food food;
    
    @ManyToOne
    @JoinColumn(name = "rid")
    private Restaurant restaurant;
    
	private double price;
	
	public Menu() {}

	public Menu(int menuid, Food food, Restaurant restaurant, double price) {
		super();
		this.menuid = menuid;
		this.food = food;
		this.restaurant = restaurant;
		this.price = price;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", food=" + food + ", restaurant=" + restaurant + ", price=" + price + "]";
	}
	
}
