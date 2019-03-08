package com.infosys.Account.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Account {
	
	@Id
	@Column(name = "email", nullable = false)
	String email;
	@Column(nullable = false, length = 50)
	String name;
	@Column(nullable = false, length = 50)
	String password;
	@Column(nullable = false, length = 50)
	String accountType;
	@Column(nullable = false)
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	int wishList_Id;
	
	
	public int getWishList_ID() {
		return wishList_Id;
	}
	public void setWishList_Id(int wishList_ID) {
		this.wishList_Id = wishList_ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
}
