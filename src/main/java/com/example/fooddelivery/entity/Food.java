package com.example.fooddelivery.entity;

import java.util.Set;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private int fid;
	private String foodname;
	private String description;
	private String image;
    @NotFound(action = NotFoundAction.IGNORE)
	private double price;
	    
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void seImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Food [foodid=" + fid + ", foodname=" + foodname + ", description=" + description + "]";
	}
	
}
