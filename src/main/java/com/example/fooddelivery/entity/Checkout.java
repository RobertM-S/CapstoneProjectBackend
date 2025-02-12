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
public class Checkout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private int fid;
	private String foodname;
	private String image;
	private double price;
	private int quantity;
	private double totalprice;
	private int rid;
	    
	public Checkout() {}

	public int getFid() {
		return fid;
	}

	public void setFid(int fSid) {
		this.fid = fid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Checkout [foodid=" + fid + ", foodname=" + foodname + ", image=" + image + ", price=" + price
				+ ", quantity=" + quantity + ", totalprice=" + totalprice + "]";
	}
	
}
