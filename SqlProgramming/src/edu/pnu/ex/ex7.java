package edu.pnu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ex7 {
	static void show_query(Connection con, String query) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsdm = rs.getMetaData();
		int count = rsdm.getColumnCount();
		
		System.out.println("=".repeat(80));
		System.out.println(rsdm.getTableName(1));
		System.out.println("=".repeat(80));
		
		ArrayList <Countrylanguage> arr = new ArrayList<Countrylanguage>();
		while(rs.next()) {
			for(int i = 1; i <= count; i++) {
				if(i != 1) System.out.print(",");
				System.out.print(rs.getString(i));
			}
			Countrylanguage cl = new Countrylanguage();
			System.out.println();
		}
		rs.close();
		st.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			
			show_query(con, s);
			
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}