package com.infosys.Account.DTO;

import com.infosys.Account.Entity.Account;

public class AccountDTO {
	private String name;
	private String email;
	private String password;
	private String accountType;
	private int wishList_Id;
	
	
	public int getWishList_Id() {
		return wishList_Id;
	}
	public void setWishList_Id(int wishList_Id) {
		this.wishList_Id = wishList_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public Account createEntity() {
		Account acctEntity = new Account();
		acctEntity.setEmail(this.email);
		acctEntity.setName(this.name);
		acctEntity.setPassword(this.password);
		acctEntity.setAccountType(this.accountType);
		acctEntity.setWishList_Id(this.wishList_Id);
		return acctEntity;
	}
	
	public static AccountDTO valueOf(Account acct) {
		AccountDTO acctDTO = new AccountDTO();
		acctDTO.setEmail(acct.getEmail());
		acctDTO.setName(acct.getName());
		acctDTO.setPassword(acct.getPassword());
		acctDTO.setAccountType(acct.getAccountType());
		acctDTO.setWishList_Id(acct.getWishList_ID());
		return acctDTO;
	}
}
