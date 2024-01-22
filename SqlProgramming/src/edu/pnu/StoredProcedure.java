package edu.pnu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcedure {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			//exeProc(con);
			//exeProc2(con);
			//exeProc3(con);
			//System.out.println("=".repeat(10));
			//exeProc4(con);
			exeProc5(con);
			
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

	private static void exeProc(Connection con) {
		try {
			CallableStatement cs = con.prepareCall("CALL myFirst(?)");
			
			cs.setString(1, "Kids Place");
			
			ResultSet rs = cs.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString("cust_name") + ",");
				System.out.print(rs.getString("cust_contact") + ",");
				System.out.print(rs.getString("cust_email") + ",");
				System.out.println();
			}
			rs.close();
			cs.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
	
	private static void exeProc2(Connection con) {
		try {
			CallableStatement cs = con.prepareCall("CALL myStoredProd1(?, ?)");
			cs.setString(1, "user3%");
			cs.registerOutParameter(2, Types.INTEGER);
			
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 2; i <= md.getColumnCount(); i++) {
						System.out.print("," + rs.getString(i));
					}
					System.out.println();
				}
			}
			System.out.println("=".repeat(10));
			System.out.println(cs.getInt(2));
	
			rs.close();
			cs.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}

	private static void exeProc3(Connection con) {
		try {
			CallableStatement cs = con.prepareCall("CALL nationLanguage01()");
			
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 2; i <= md.getColumnCount(); i++) {
						System.out.print("," + rs.getString(i));
					}
					System.out.println();
				}
			}

			rs.close();
			cs.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
	
	private static void exeProc4(Connection con) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("국가 이름을 입력하세요");
			String nation = sc.nextLine();
			CallableStatement cs = con.prepareCall("CALL nationLanguage02(?)");
			cs.setString(1, nation);
			
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 2; i <= md.getColumnCount(); i++) {
						System.out.print("," + rs.getString(i));
					}
					System.out.println();
				}
			}

			rs.close();
			cs.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
	private static void exeProc5(Connection con) {
		try {
			CallableStatement cs = con.prepareCall("CALL nationLanguage03(?, ?)");
			cs.setString(1, "United States");
			cs.registerOutParameter(2, Types.DOUBLE);
			
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 2; i <= md.getColumnCount(); i++) {
						System.out.print("," + rs.getString(i));
					}
					System.out.println();
				}
			}
			System.out.println("Max Percentage : " + cs.getDouble(2));
	
			rs.close();
			cs.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
}
