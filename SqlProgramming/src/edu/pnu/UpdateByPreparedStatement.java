package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateByPreparedStatement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			while(true) {
				System.out.println("user 번호를 입력하세요");
				String n = sc.next();
				if(Integer.parseInt(n) < 1 || Integer.parseInt(n) > 100) {
					break;
				}
				System.out.println("true, false 입력하세요");
				Boolean b = sc.nextBoolean();
				
				PreparedStatement pt = con.prepareStatement("update user set enable = ? where username like ?;");
				pt.setBoolean(1, b);
				pt.setString(2, "user" + n);
				pt.executeUpdate();
				pt.close();
			}
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
