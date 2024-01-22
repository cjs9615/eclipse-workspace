package com.ruby.java.ch11;

public class Test01 {
	public static void main(String[] args) {
		/*
		int arr[] = new int[3];
		arr[3] = 30;
		System.out.println("OK");
		*/
		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length();
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 배열의 인덱스 사용!" + e.getMessage());
		} catch(NullPointerException e2) {
			System.out.println("잘못된 참조!" + e2.getMessage());
		}
		System.out.println("GOOD");
	}
}
