package edu.pnu.h2;

import java.util.List;
import java.util.Scanner;


public class h2test {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		System.out.println("query 입력하세요.");
		//String query = sc.nextLine();
		MyJDBC mj = new MyJDBC("org.h2.Driver", 
								"jdbc:h2:tcp://localhost/~/h2/jdbcstudy", 
								"sa", 
								"abcd");
		
		List<List<String>> list = mj.querywithStatement("select * from testtable");
		
		List<List<String>> list1 = mj.queryInsertStatement();
		
		
		
		

		mj.printList(list1);
	}
}
