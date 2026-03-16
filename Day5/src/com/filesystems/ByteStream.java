package com.filesystems;

import java.io.Serializable;

class Student implements Serializable {
	int id;
	String name;
	int salary;
	String designation;
	public Student(int id, String name, int i, String designation) {
		this.id = id;
		this.name = name;
		this.salary = i;
		this.designation = designation;
		
	}

}

public class ByteStream {
	public static void main(String[] args) {
		try {
			Student s = new Student(1010, "Anand", 50000, "Software Engineer");
			java.io.FileOutputStream fos = new java.io.FileOutputStream("C:\\Users\\SMK5\\Downloads\\SampleText.txt");
			java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
			fos.close();
			System.out.println("Object serialized successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream("C:\\Users\\SMK5\\Downloads\\SampleText.txt");
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis);
			Student s2 = (Student) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Object deserialized successfully.");
			System.out.println("ID: " + s2.id);
			System.out.println("Name: " + s2.name);
			System.out.println("Salary: " + s2.salary);
			System.out.println("Designation: " + s2.designation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
