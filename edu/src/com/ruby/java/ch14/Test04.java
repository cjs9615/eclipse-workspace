package com.ruby.java.ch14;

import java.util.Scanner;

interface Verify2 {
	boolean check(int n, int d);
}

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 1;
		int b = 1;
		Verify2 vf = (n, d) -> (n % d) == 0;
		while(a != 0) {
			System.out.print("숫자를 입력하세요");
			a = sc.nextInt();
			System.out.print("숫자를 입력하세요");
			b = sc.nextInt();
			System.out.println(vf.check(a, b));
		}
		
		//Verify2 vf = (n, d) -> (n % d) == 0;
		//System.out.println(vf.check(24, 3));
	}
}
