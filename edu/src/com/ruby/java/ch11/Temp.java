package com.ruby.java.ch11;

public class Temp {
	private static int test3() throws Exception {
		int a = 30;
		int b = 0;
		
		return a/b;
	}
	private static int test2() throws Exception {
		return test3();
	}
	private static int test1() throws Exception {
		return test2();
	}
	public static void main(String[] args) {
		int div = 0;
		try {
			div = test1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("div:" + div);
	}
}
