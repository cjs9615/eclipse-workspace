package com.ruby.java.ch09;

import java.util.Random;
import java.util.StringTokenizer;

public class Test01 {
	public static void main(String[] args) {
		Random r1 = new Random();
		System.out.println("난수 = " + r1.nextInt());
		System.out.println("난수 = " + r1.nextInt(10));
		String s = "id=guest name=Amy pwd=1004";
		StringTokenizer st = new StringTokenizer(s);
		st.countTokens();
		while(st.hasMoreTokens()) {
			System.out.println("토큰수 = " + st.countTokens());
			System.out.println(st.nextToken());
		}
		int i3 = Integer.parseInt("123");
		int i = 123;
		Integer obj6 = Integer.valueOf(i);// 박싱
		Integer obj7 = 22;
		int nx = obj6.intValue();// 언박싱
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println(obj1);
	}
}
