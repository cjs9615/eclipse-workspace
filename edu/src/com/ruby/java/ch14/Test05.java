package com.ruby.java.ch14;

import java.util.Scanner;

interface NumberFunc {
	int func(int n, int m);
}

public class Test05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NumberFunc sum = (n , m) -> {
			int result = 0;
			for(int i = n; i <= m; i++) {
				result += i;
			}
			return result;
		};
		while(true) {
			System.out.print("숫자 2개를 입력하세요");
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0) break;
			if(b == 0) break;
			if(a > b) {
				int temp;
				temp = a;
				a = b;
				b = temp;
			}
			System.out.println(a + "부터 " + b + "까지의 합 : " + sum.func(a, b));
		}
		
	}
}
