package com.ruby.java.ch03;

import java.util.Scanner;

public class Test21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a:");
		int a = sc.nextInt();
		System.out.print("b:");
		int b = sc.nextInt();
		System.out.print("op:");
		String op = sc.next();
		
		switch(op) {
		case "+":
			System.out.println(a + b); break;
		case "-":
			System.out.println(a - b); break;
		case "*":
			System.out.println(a * b); break;
		case "/":
			System.out.println(a / b); break;
		default:
			System.out.println("잘못된 입력입니다."); break;
		}
	}
}
