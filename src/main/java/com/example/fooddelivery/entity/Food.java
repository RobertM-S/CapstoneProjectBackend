package com.example.fooddelivery.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String foodname;
	private String description;
	
    @OneToMany(mappedBy = "food")
    Set<Menu> menu;
	
    @OneToMany(mappedBy = "food")
    Set<Orders> orders;
	
	public Food() {}
	
	public Food(int fid, String foodname, String description) {
		super();
		this.fid = fid;
		this.foodname = foodname;
		this.description = description;
	}

	public int getFoodid() {
		return fid;
	}

	public void setFoodid(int fid) {
		this.fid = fid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Food [foodid=" + fid + ", foodname=" + foodname + ", description=" + description + "]";
	}
	
}
