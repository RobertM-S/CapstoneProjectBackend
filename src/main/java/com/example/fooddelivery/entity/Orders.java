package com.example.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
    @ManyToOne
    @JoinColumn(name = "fid")
	private Food food;
    
    @ManyToOne
    @JoinColumn(name = "uid")
	private User user;
    
    @ManyToOne
    @JoinColumn(name = "rid")
	private Restaurant restaurant;
    
    private int orderblock;
    
    public Orders() {}

	public Orders(int oid, Food food, User user, Restaurant restaurant, int orderblock) {
		super();
		this.oid = oid;
		this.food = food;
		this.user = user;
		this.restaurant = restaurant;
		this.orderblock = orderblock;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getOrderblock() {
		return orderblock;
	}

	public void setOrderblock(int orderblock) {
		this.orderblock = orderblock;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", food=" + food + ", user=" + user + ", restaurant=" + restaurant
				+ ", orderblock=" + orderblock + "]";
	}
    
}
