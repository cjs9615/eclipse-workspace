package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;
	
	public Member() {
		name = "a";
		age = 10;
	}
	
	public Member(String name) {
		super();
		this.name = name;
		age = 100;
	}

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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
	

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		Member member1 = new Member();
		System.out.println(member1);
		Member member2 = new Member("b", 20);
		System.out.println(member2);
		Member member3 = new Member("c");
		System.out.println(member3);
	}
}
