package com.giuseppe.demo.model;



import java.util.List;



import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String AccountNumber;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String address;
	private String phone;
	private double balance;



	public User() {
		this.AccountNumber = generateAccountNumber();
		this.balance = 0;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String generateAccountNumber() {
		UUID accountNumber = UUID.randomUUID();
		return accountNumber.toString().replaceAll("-", "").substring(0, 10);
	}

	@OneToMany(mappedBy = "user")
	private List<Transaction> transactions;
	@OneToMany(mappedBy = "user")
	private List<Transaction> recipientTransactions;


}