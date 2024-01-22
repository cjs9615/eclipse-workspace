package com.ruby.java.ch02;

public class Test5 {

	public static void main(String[] args) {
		int A1 = 334;
		int A2 = 20;
		A2 = A2 + 1;
		A2++;
		int num = A2++;
		int num2 = ++A2;
		System.out.println("num="+num+" num2=" +num2);
		int A3 = A1 % A2;
		System.out.println("A3 = " + A3);
	}

}
