package com.ruby.java.ch10;

import java.util.Map;
import java.util.TreeMap;

public class Test09 {
	public static void main(String[] args) {
		TreeMap<String, String> users = new TreeMap<String, String>();
		
		users.put("20080319", "김푸름");
		users.put("20070620", "김하늘");
		users.put("20050817", "오정임");
		users.put("20120728", "김유빈");
		users.put("20120924", "김용빈");
		
		System.out.println(users);
		
		Map.Entry<String, String> entry = null;
		
		entry = users.firstEntry();
		System.out.println(entry);
		//print("입사일자가 가장 빠른 사람", entry);
	}
}
