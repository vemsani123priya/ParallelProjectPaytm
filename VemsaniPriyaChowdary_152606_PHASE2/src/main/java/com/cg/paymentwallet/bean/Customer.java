package com.cg.paymentwallet.bean;

public class Customer {
	private String name;
	private String adharNumber;
	private String phoneNumber;
	private String email;
	private int age;
	private String gender;
	//private float balance;
	//private int accountNumber;
    private String userName;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", adharNumber=" + adharNumber + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", age=" + age + ", gender=" + gender + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	




}
