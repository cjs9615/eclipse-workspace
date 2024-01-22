package com.ruby.java.ch03;

import java.util.Scanner;

public class Test28 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("cnt: ");
			int cnt = sc.nextInt();
			if(cnt <= 0) break;
			System.out.println("A(all), O(odd), E(even)");
			System.out.print("flag: ");
			String flag = sc.next(); // A(all), O(odd), E(even)
			int sum = 0;
			
			int a = 0;
			int b = 0;
			
			/*
			if (flag.equals("A")) {
				a = 1; b = 1;
			}
			else if (flag.equals("O")) {
				a = 1; b = 2;
			}
			else if (flag.equals("E")) {
				a = 2; b = 2;
			} else {
				continue;
			}
			
			for (int i = a; i <= cnt; i+=b) {
				sum += i;
			}
			*/
			
			switch(flag) {
				case "A":
					a = 1; b = 1; break;
				case "O":
					a = 1; b = 2; break;
				case "E":
					a = 2; b = 2; break;
				
			}
			for (int i = a; i <= cnt; i+=b) {
				sum += i;
			}
			
			
			/*
			if (flag.equals("A")) {
				for (int i = 1; i <= cnt; i++) {
					sum += i;
				}
			}
			else if(flag.equals("O")) {
				for (int i = 1; i <= cnt; i+=2) {
					sum += i;
				}
			}
			else if(flag.equals("E")) {
				for (int i = 2; i <= cnt; i+=2) {
					sum += i;
				}
			}
			*/
			System.out.println("sum: " + sum);
		}
		System.out.println("Good Bye!");
	}
}
