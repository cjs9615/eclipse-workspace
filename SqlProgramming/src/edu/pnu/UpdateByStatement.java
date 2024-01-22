package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateByStatement {
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

			System.out.println(st.executeUpdate("update user set enable = false where username like 'user2%';"));
			
			
			st.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
