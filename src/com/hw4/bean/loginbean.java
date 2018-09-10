package com.hw4.bean;

public class loginbean {
private String username;
private String password;

public String getUser() {
	System.out.println("loginben getmail"+username);
	return username;
}

public void setUser(String username) {
	this.username = username;
System.out.println("loginben setemail"+username);
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}}
