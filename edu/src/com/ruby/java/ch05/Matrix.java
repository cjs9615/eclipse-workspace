package com.ruby.java.ch05;

import java.util.Random;

public class Matrix {
	static void addMatrix(int [][]A, int [][]B) {
		int c[][] = new int[3][4];
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				c[i][j] = A[i][j] + B[i][j];
			}
		}
		System.out.println("덧셈 결과");
		showMatrix(c);
	}
	static void multiplyMatrix(int [][]A, int [][]D) {
		int [][]e = new int[A.length][D[0].length];
		for(int i = 0; i < e.length; i++) {
			for(int j = 0; j < e[i].length; j++) {
				for(int k = 0; k < D.length; k++) {
					e[i][j] += A[i][k] * D[k][j];
				}
			}
		}
		System.out.println("곱셈 결과");
		showMatrix(e);
	}
	static void showMatrix(int[][]a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Random random = new Random();
		int a[][] = new int [3][4];
		int b[][] = new int [3][4];
		int d[][] = new int [4][5];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = random.nextInt(5);
			}
		}
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				b[i][j] = random.nextInt(5);
			}
		}
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				d[i][j] = random.nextInt(5);
			}
		}
		showMatrix(a);
		showMatrix(b);
		addMatrix(a, b);
		showMatrix(a);
		showMatrix(d);
		multiplyMatrix(a, d);
	}
}
