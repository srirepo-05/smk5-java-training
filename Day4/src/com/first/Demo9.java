package com.first;

import java.util.Optional;

class Student {
	String email;
	public Student(String email) {
		this.email = email;
	}
	Optional<String> getEmail() {
		return Optional.ofNullable(email);
	}
}
public class Demo9 {
	public static void main(String[] args) {
		Student s = new Student(null);
	   Optional<String>  email=  s.getEmail();
	   if (email.isPresent()) {
		System.out.println(email.get().length());
	} else {
		System.out.println("email is not available");

	}
	}
}
