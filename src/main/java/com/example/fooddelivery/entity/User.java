package com.example.fooddelivery.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String firstname;
	private String surname;
	private String email;
	private String phone;
	
    @OneToMany(mappedBy = "user")
    Set<Useraddress> userAddress;
    
    @OneToMany(mappedBy = "user")
    Set<Orders> orders;
	
	public User() {}

	public User(int uid, String firstname, String surname, String email, String phone) {
		super();
		this.uid = uid;
		this.firstname = firstname;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public int getuid() {
		return uid;
	}

	public void setuid(int uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstname=" + firstname + ", surname=" + surname + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
}
