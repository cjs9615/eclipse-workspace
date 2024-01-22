package com.ruby.java.ch07.상속;

public class Employee extends Person{
	//private String name;
	//private int age;
	private String dept;
	
	public Employee() {
		System.out.println("Employee 생성자 실행!");
	}
	public Employee(String name, int age, String dept) {
		super(name, age); this.dept = dept;
		//super.setName(name); super.setAge(age); this.dept = dept;
	}
	/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	*/
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		//return getName() + ":" + getAge() + " dept:" + dept;
		//return name + ":" + age + dept;
		return super.toString() + " dept:" + dept;
	}
}
