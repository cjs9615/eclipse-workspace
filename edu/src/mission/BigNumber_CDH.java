package mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BigNumber_CDH {
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "";
		String[] a = new String[0];
		String[] b = new String[0];
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			s1 = br.readLine();
			s2 = br.readLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
		a = s1.split("");
		b = s2.split("");
		
		List<String> a1 = new ArrayList<>();
		List<String> b1 = new ArrayList<>();
		if(a.length >= b.length) {
			a1 = Arrays.asList(a);
			b1 = Arrays.asList(b);
		}
		else {
			a1 = Arrays.asList(b);
			b1 = Arrays.asList(a);
		}
		List<Integer> c = new ArrayList<>();
		for(int i = 0; i < b1.size(); i++) {
			c.add(Integer.parseInt(a1.get(i)) + Integer.parseInt(b1.get(i)));
		}
		for(int i = b1.size(); i < a1.size(); i++) {
			c.add(Integer.parseInt(a1.get(i)));
		}
		for(int i = 0; i < c.size(); i++) {
			int n1 = 0;
			int n2 = 0;
			if(c.get(i) > 9) {
				if(i == c.size()-1) {
					n1 = c.get(i) % 10;
					c.set(i, n1);
					c.add(1);
				}
				else {
					n1 = c.get(i) % 10;
					n2 = c.get(i+1) + 1;
					c.set(i, n1);
					c.set(i+1, n2);
				}
			}
		}
		Collections.reverse(c);
		System.out.println("첫번째 숫자");
		for(String i : a1) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("두번째 숫자");
		for(String i : b1) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("더한 결과");
		for(int i : c) {
			System.out.print(i);
		}
		
		/*
		List<String> a1 = Arrays.asList(a);
		List<String> b1 = Arrays.asList(b);
		Collections.reverse(a1);
		Collections.reverse(b1);
		List<Integer> c = new ArrayList<>();
		int bigSize = 0;
		int smallSize = 0;
		if(a1.size() > b1.size()) {
			bigSize = a1.size();
			smallSize = b1.size();
		}
		else {
			bigSize = b1.size();
			smallSize = a1.size();
		}
		for(int i = 0; i < smallSize; i++) {
			c.add(Integer.parseInt(a1.get(i)) + Integer.parseInt(b1.get(i)));
		}
		for(int i = smallSize; i < bigSize; i++) {
			if(a1.size() > b1.size()) {
				c.add(Integer.parseInt(a1.get(i)));
			}
			else {
				c.add(Integer.parseInt(b1.get(i)));
			}
		}
		for(int i = 0; i < c.size(); i++) {
			int n1 = 0;
			int n2 = 0;
			if(c.get(i) > 9) {
				if(i == c.size()-1) {
					n1 = c.get(i) % 10;
					c.set(i, n1);
					c.add(1);
				}
				else {
					n1 = c.get(i) % 10;
					n2 = c.get(i+1) + 1;
					c.set(i, n1);
					c.set(i+1, n2);
				}
			}
		}
		Collections.reverse(c);
		System.out.println("첫번째 숫자");
		for(String i : a1) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("두번째 숫자");
		for(String i : b1) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("더한 결과");
		for(int i : c) {
			System.out.print(i);
		}
		*/
	}
}
