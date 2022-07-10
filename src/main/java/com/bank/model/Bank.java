package com.bank.model;

public class Bank {
	private String email1;
	private String password1;
	private int accno;
	private String status;
	private String adno;
	private String name;
	private String city;
	private String mno;
	private String Email2;       
	private String password2;    
	private int balance;
	private int ammount;
	private int receipientacc;
	public Bank() {
		super();
	}
	public Bank(String email1, String password1, int accno, String status, String adno, String name, String city,
			String mno, String email2, String password2, int balance, int ammount, int receipientacc) {
		super();
		this.email1 = email1;
		this.password1 = password1;
		this.accno = accno;
		this.status = status;
		this.adno = adno;
		this.name = name;
		this.city = city;
		this.mno = mno;
		Email2 = email2;
		this.password2 = password2;
		this.balance = balance;
		this.ammount = ammount;
		this.receipientacc = receipientacc;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdno() {
		return adno;
	}
	public void setAdno(String adno) {
		this.adno = adno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getEmail2() {
		return Email2;
	}
	public void setEmail2(String email2) {
		Email2 = email2;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public int getReceipientacc() {
		return receipientacc;
	}
	public void setReceipientacc(int receipientacc) {
		this.receipientacc = receipientacc;
	}

	
}