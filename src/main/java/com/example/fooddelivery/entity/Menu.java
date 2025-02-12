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
	private int mid;
    
    @ManyToOne
    @JoinColumn(name = "rid")
    private Restaurant restaurant;
    
	private double price;
	
	private String image;
	
	public Menu() {}

	public Menu(int mid, double price, String image) {
		super();
		this.mid = mid;
		this.price = price;
		this.image = image;
	}

	public int getmid() {
		return mid;
	}

	public void setmid(int mid) {
		this.mid = mid;
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", restaurant=" + restaurant + ", price=" + price + "]";
	}
	
}
