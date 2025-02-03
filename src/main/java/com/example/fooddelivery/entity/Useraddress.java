package com.example.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Useraddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uaid;
	
    @ManyToOne
    @JoinColumn(name = "uid")
	private User user;
    
    @ManyToOne
    @JoinColumn(name = "aid")
    private Address address;
	
    public Useraddress() {}

	public Useraddress(int uaid, User user, Address address) {
		super();
		this.uaid = uaid;
		this.user = user;
		this.address = address;
	}

	public int getuaid() {
		return uaid;
	}

	public void setuaid(int uaid) {
		this.uaid = uaid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserAddress [uaid=" + uaid + ", user=" + user + ", address=" + address + "]";
	}
    
}
