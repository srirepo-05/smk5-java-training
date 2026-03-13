package com.api;

import java.time.LocalDate;
//java Time API
import java.util.Vector;
import java.time.Period;

public class Demo1 {
	public static void main(String[] args) {
//today date
		LocalDate today = LocalDate.now();
//	employee Joining data
		LocalDate joiningDate = LocalDate.of(2020, 3, 10);
		System.out.println("today " + today);
		System.out.println("Joinini data  " + joiningDate);
		//find years and months between today and joining date
		Period experience = Period.between(joiningDate, today);
		System.out.println("Experience " + experience.getYears() + " years and " + experience.getMonths() + " months");
		
		

	}
}