package com.example.fooddelivery.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String city;
	private String postcode;
	private String street;
	private int number;
	
    @OneToMany(mappedBy = "address")
    Set<Restaurantaddress> restaurantAddress;
    
    @OneToMany(mappedBy = "address")
    Set<Useraddress> userAddress;
	
	public Address() {}

	public Address(int aid, String city, String postcode, String street, int number) {
		super();
		this.aid = aid;
		this.city = city;
		this.postcode = postcode;
		this.street = street;
		this.number = number;
	}

	public int getAddressid() {
		return aid;
	}

	public void setAddressid(int aid) {
		this.aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", postcode=" + postcode + ", street=" + street
				+ ", number=" + number + "]";
	}
	
}
