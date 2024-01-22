package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertByStatement {
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			for(int i = 1; i <= 100; i++) {
				String j = Integer.toString(i);
				System.out.println("user" + i + ":" + st.executeUpdate(String.format("INSERT INTO user (username,password,role,enable,joindate) VALUES('user%s','password%s','user',true,now());", j, j)));
			}
			
			st.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
