package com.ruby.java.ch02;

public class Test13 {

	public static void main(String[] args) {
		byte a = 0b00010001;
		byte b = 0b00100010;
		int c = a & b;
		System.out.println(Integer.toBinaryString(c));
	}

}
