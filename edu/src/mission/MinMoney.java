package mission;

import java.util.Scanner;

public class MinMoney {
	
	private int[] money = {50000, 10000, 5000, 1000};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가격을 입력하세요:");
		int price = sc.nextInt();
		
		MinMoney minmoney = new MinMoney();
		minmoney.printMoney(price);
	}
	
	void printMoney(int price) {
		int moneyTotal = 0;
		for(int i = 0; i < money.length; i++) {
			int moneyCount = price / money[i];
			moneyTotal += moneyCount;
			System.out.println(money[i] + " * " + moneyCount + "장");
			price %= money[i];
		}
		System.out.println("필요한 지폐 총 수 : " + moneyTotal);
	}
}
