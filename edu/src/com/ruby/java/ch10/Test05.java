package com.ruby.java.ch10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test05 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("광주");
		list.add("제주");
		list.add("인천");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		list.remove(2);
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " > ");
		}
		//list.sort(null);
		list.sort(null);
		System.out.println();
		Iterator<String> iter2 = list.iterator();
		while(iter2.hasNext()) {
			System.out.print(iter2.next() + " > ");
		}
		
		
		list.add(1, "LA");
		list.addFirst("런던");
		list.addLast("서울");
		
		List<String> list2 = Arrays.asList("북경", "상해");
		list.addAll(list2);
		
	}
}
