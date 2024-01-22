package com.ruby.java.ch08.polymorphism;

abstract class Employee {// 추상 클래스
	String name;
	int salary;
	
	public Employee() {
		//자동으로 추가
	}
	public abstract void calcSalary();//추상 메소드
	public void show() {
		System.out.println("name = " + name + "salary");
	}
}

class Salesman extends Employee {
	int annual_sales;
	public Salesman() {//자동으로 삽입
		super();//자동으로삽입
	}
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
}
class Consultant extends Employee {
	int num_project;
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 판매 수당");
	}
}
abstract class Manager extends Employee {
	int num_team;
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 판매 수당");
	}
}
class Director extends Manager {
	public void calcBonus() {
		System.out.println("이사");
	}
}
public class HRSTest {
	public static void calcTax(Employee e) {
		if(e instanceof Salesman) {
			Salesman s = (Salesman) e;//type casting
			System.out.println(e + "는 세일즈맨 객체");
			System.out.println(s.annual_sales);
		}
		
		double tax = 0;
		if(e.getClass().getName() == "Director") {
			tax = e.salary * 0.2;
		}
		else {
			tax = e.salary * 0.1;
		}	
		System.out.println("세일즈맨 세금 = " + tax);
	}
	public static void main(String[] args) {
		//Employee e = new Employee();
		Salesman s = new Salesman();
		Employee e = new Salesman();
		Object o = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		//Manager m = new Manager();
		
		s.calcSalary();
		calcTax(s);
		calcTax(d);
		calcTax(c);
	}
}
