package edu.pnu.sakila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyQuery {

	public static void main(String[] args) throws Exception {
		
		StudyQuery sq = new StudyQuery();
		
		// database 연결 (con)
		Connection con = sq.getConnection();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Table 이름을 입력하세요.");
			String tablename = sc.next();
			if(tablename.equals("quit")) {
				break;
			}
			// 질의 (결과로서 배열을 받는다)
			List<List<String>> list = sq.getQueryResult(con, tablename);
			
			// 결과 출력
			
			sq.printResult(list);
		}
		
		con.close();
	}

	private void printResult(List<List<String>> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++) {
				if(j != 0)
					System.out.print(",");
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
		
	}

	private List<List<String>> getQueryResult(Connection con, String tablename) throws Exception {
		List<List<String>> list = new ArrayList<List<String>>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * " + "from " + tablename);
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
		
		return list;
	}

	private Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/sakila";
		String username = "scott";
		String password = "tiger";

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
}
