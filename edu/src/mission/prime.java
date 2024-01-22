package mission;

import java.util.Scanner;

public class prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		int num = sc.nextInt();
		
		if(num < 2) {
			System.out.println("더 큰 수를 입력하세요.");
			return;
		}
		int i = 0;
		int len = num/2;
		for(i = 2; i <= len; i++) {
			if(num%i == 0) {
				break;
			}
		}
		if(len < i) {
			System.out.println("소수입니다.");
		}
		else {
			System.out.println("소수가 아닙니다.");
		}
	
		

	}

}
