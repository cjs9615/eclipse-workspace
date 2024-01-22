package com.ruby.java.ch07.추상;

abstract class Employee {// 추상 클래스
	String name;
	int salary;
	
	public abstract void calcSalary();//추상 메소드
	public void show() {
		System.out.println("name = " + name + "salary");
	}
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
}
class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 판매 수당");
	}
}
class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 판매 수당");
	}
}
public class HRSTest {
	public static void main(String[] args) {
		//Employee e = new Employee();
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Manager m = new Manager();
		
		s.calcSalary();
	}
}
