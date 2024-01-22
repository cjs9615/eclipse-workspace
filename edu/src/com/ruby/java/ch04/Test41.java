package com.ruby.java.ch04;

public class Test41 {

	public static void main(String[] args) {
		
		int cnt = Integer.parseInt(args[0]);
		for(int i = 1; i <= 9; i++) {
			System.out.println(cnt + "*" + i + "=" + (cnt*i));
		}
		

	}

}
