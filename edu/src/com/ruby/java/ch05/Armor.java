package com.ruby.java.ch05;


public class Armor {
	public void speedUp(double value) {
		double speed = value;
	}
	public void speedUp(int value, int maxValue) {
		int speed = value;
		int maxSpeed = maxValue;
	}
	
	String name;
	int height;
	int weight;
	String color;
	boolean isFly;
	
	void takeOff() {
		speedUp(10);
		speedUp(10,20);
	}
	int land() {
		return 10;
	}
	void shootLaser() {}
	void launchMissile() {}
	
	public static void main(String[] args) {
		Armor armor = new Armor();
		armor.takeOff();
	}
}
