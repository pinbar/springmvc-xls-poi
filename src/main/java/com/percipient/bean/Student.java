package com.percipient.bean;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setName(String name) {
		String[] strArr = name.split(" ");
		this.firstName = strArr[0];
		this.lastName = strArr[1];
	}
}
