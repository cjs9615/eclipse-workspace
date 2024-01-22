package com.ruby.java.ch03;

import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Num:");
		int num = sc.nextInt();
		int sum = 0;
		for(int i = 0; i <= num; i+=2) {
			sum += i;
		}
		System.out.println("Sum:" + sum);
	}
}
