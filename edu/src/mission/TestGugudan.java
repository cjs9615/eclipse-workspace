package mission;

import java.util.Scanner;

public class TestGugudan {

	public void printGugudan(int n) {
		/*
		if(n == 1) {
			for(int i = 2; i <= 9; i+=n) {
				for(int j = 1; j <= 9; j++) {
					System.out.println(i + "x" + j + "=" + i*j);
				}
			}
		}
		else if(n == 2) {
			for(int i = 2; i <= 9; i+=n) {
				for(int j = 1; j <= 9; j++) {
					System.out.print(i + "x" + j + "=" + i*j +  "\t");
					i++;
					System.out.println(i + "x" + j + "=" + i*j +  "\t");
					i--;
				}
				System.out.println();			}
		}
		else if(n == 3) {
			for(int i = 2; i <= 9; i+=n) {
				for(int j = 1; j <= 9; j++) {
					System.out.print(i + "x" + j + "=" + i*j +  "\t");
					i++;
					System.out.print(i + "x" + j + "=" + i*j +  "\t");
					i++;
					if(i < 10) {
						System.out.println(i + "x" + j + "=" + i*j +  "\t");
					}
					else {
						System.out.println("\t");
					}
					i--;
					i--;
				}
				System.out.println();		
			}
		}
		for(int i = 2; i <= 9; i+=n) {
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + "*" + j + "=" + i*j +  "\t");				
				for(int k = 2; k <= n; k++) {
					i++;
					if(i < 10) {
						System.out.print(i + "*" + j + "=" + i*j +  "\t");
					}
					else {
						System.out.print("\t");
					}
				}
				for(int k = 2; k <= n; k++) {
					i--;
				}
				System.out.println();	
			}
			System.out.println();
		}
		*/
		for(int i = 2; i <= 9; i+=n) {
			for(int j = 1; j <= 9; j++) {				
				for(int k = 0; k < n; k++) {
					if(i+k < 10) {
						System.out.print((i+k) + "*" + j + "=" + (i+k)*j +  "\t");
					}					
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestGugudan gg = new TestGugudan();
		System.out.println("숫자를 입력하세요(2~8)");
		gg.printGugudan(sc.nextInt());
	}
}
