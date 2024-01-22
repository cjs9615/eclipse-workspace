package com.ruby.java.ch08.polymorphism;
//polymorphism 실습 예제 코드

abstract class Vehicle {
	String engineType;
	int numberWheels;
	
	public Vehicle(String engineType, int numberWheels) {
		this.engineType = engineType; this.numberWheels = numberWheels;
	}
	public abstract void displayWheels();
	
}
class Truck extends Vehicle {
	int weight;
	public Truck(String engineType, int numberWheels, int weight) {
		super(engineType, numberWheels); this.weight = weight;
	}
	public void displayWheels() {
		System.out.println("트럭의 바퀴수는 " + numberWheels);
	}
}
class Car extends Vehicle {
	int vehicleOccupants;
	public Car(String engineType, int numberWheels, int vehicleOccupants) {
		super(engineType, numberWheels); this.vehicleOccupants = vehicleOccupants;
	}
	public void displayWheels() {
		System.out.println("승용차의 바퀴수는 " + numberWheels);
	}
}
class MotorCycle extends Vehicle {
	int price;
	public MotorCycle(String engineType, int numberWheels, int price) {
		super(engineType, numberWheels); this.price = price;
	}
	public void displayWheels() {
		System.out.println("오토바이의 바퀴수는 " + numberWheels);
	}
}
public class ch08_test_polymorphism실습 {
	public static void checkWheels(Vehicle [] a) {
		for (Vehicle v : a) {
			v.displayWheels();
		}
	}
	public static void main(String[] args) {
		Vehicle [] arr = new Vehicle[5];
		arr[0] = new Truck("a", 8, 10);
		arr[1] = new Car("c", 4, 4);
		arr[2] = new MotorCycle("d", 2, 5);
		arr[3] = new Truck("b", 10, 8);
		arr[4] = new MotorCycle("e", 2, 6);
		checkWheels(arr);
	}
}

