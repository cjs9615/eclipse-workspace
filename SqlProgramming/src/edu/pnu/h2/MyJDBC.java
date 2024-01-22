package edu.pnu.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	
	public MyJDBC(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	private Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	
	public List<List<String>> querywithStatement(String query) {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsdm = rs.getMetaData();
			int count = rsdm.getColumnCount();
			while(rs.next()) {
				List<String> listList = new ArrayList<String>();
				for(int i = 1; i <= count; i++) {
					listList.add(rs.getString(i));
				}
				list.add(listList);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public List<List<String>> querywithPreparedStatement(String query, int...args ) {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			PreparedStatement pt = getConnection().prepareStatement(query);
			for(int i = 0; i < args.length; i++) {
				pt.setInt(i+1, args[i]);
			}
			ResultSet rs = pt.executeQuery();
			ResultSetMetaData rsdm = rs.getMetaData();
			int count = rsdm.getColumnCount();
			while(rs.next()) {
				List<String> listList = new ArrayList<String>();
				for(int i = 1; i <= count; i++) {
					listList.add(rs.getString(i));
				}
				list.add(listList);
			}
			rs.close();
			pt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}
	
	public List<List<String>> queryInsertStatement() {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			Statement st = getConnection().createStatement();
			for(int i = 1; i <= 100; i++) {
				String j = Integer.toString(i);
				System.out.println("user" + i + ":" + st.executeUpdate(String.format("INSERT INTO testtable (name,telephone,address) VALUES('%s','010%s','%s');", j, j , j)));
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	public void printList(List<List<String>> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++) {
				if(j != 0)
					System.out.print(",");
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
	}
}