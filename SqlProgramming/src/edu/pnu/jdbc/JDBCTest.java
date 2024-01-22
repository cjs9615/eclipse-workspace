package edu.pnu.jdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		System.out.println("query 입력하세요.");
		String query = sc.nextLine();
		MyJDBC mj = new MyJDBC("com.mysql.cj.jdbc.Driver", 
								"jdbc:mysql://localhost:3306/world", 
								"scott", 
								"tiger");
		
		List<List<String>> list = mj.querywithStatement(query);
		
		List<List<String>> list1 = mj.querywithPreparedStatement(
				"select * from country where population > ? and gnp > ?",
				10000000, 100000
				);
		
		mj.printList(list);
		mj.printList(list1);
	}
}
