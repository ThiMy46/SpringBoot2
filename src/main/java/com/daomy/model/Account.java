package com.daomy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int account_id;
	private String accountname;
	private String password;
	
	public Account(){
		
	}
	
	public Account(String accountname, String password) {
		super();
		this.accountname = accountname;
		this.password = password;
	}
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
