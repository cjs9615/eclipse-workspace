package edu.pnu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ex2 {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select name, population from city where countrycode = 'KOR' order by population desc");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			System.out.println("=".repeat(80));
			System.out.println("Table : " + rsmd.getTableName(1));
			System.out.println("=".repeat(80));
			while(rs.next()) {
				for(int i = 1; i <= count; i++) {
					if(i != 1) System.out.print(",");
					System.out.print(rs.getString(i));
				}
				System.out.println();
			}
			rs.close();
			st.close();
			con.close();
		} catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
