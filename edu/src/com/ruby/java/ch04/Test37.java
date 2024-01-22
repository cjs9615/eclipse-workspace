package com.ruby.java.ch04;

import java.util.Scanner;

public class Test37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("개수:");
		
		int num = sc.nextInt();
		int[] score = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print((i+1) + "번째 입력 :");
			score[i] = sc.nextInt();
		}
		
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999;
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
			if(max < score[i])
				max = score[i];
			if(min > score[i])
				min = score[i];
		}
		
		avg = sum / score.length;
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
		

	}

}
