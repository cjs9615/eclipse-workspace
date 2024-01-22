package edu.pnu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class city{
	private int id;
	private String name;
	private String countrycode;
	private String district;
	private int population;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "city [id=" + id + ", name=" + name + ", countrycode=" + countrycode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
	
}
public class ex5 {
	static void query(Connection con, String query) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsdm = rs.getMetaData();
		int count = rsdm.getColumnCount();
		
		System.out.println("=".repeat(80));
		System.out.println(rsdm.getTableName(1));
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
	}
	//국가코드가 'KOR'이면서 인구가 100만 이상인 도시
	static void query1(Connection con) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from city where countrycode = 'KOR' and population >= 1000000;");
		ResultSetMetaData rsdm = rs.getMetaData();
		int count = rsdm.getColumnCount();
		
		System.out.println("=".repeat(80));
		System.out.println(rsdm.getTableName(1));
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
	}
	//국가코드가 'KOR'인 도시중에 인구수가 많은 순서로 상위 10개
	static void query2(Connection con) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from city where countrycode = 'KOR' order by population desc limit 10;");
		ResultSetMetaData rsdm = rs.getMetaData();
		int count = rsdm.getColumnCount();
		
		System.out.println("=".repeat(80));
		System.out.println(rsdm.getTableName(1));
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
	}
	//city 테이블에서 국가코드가 'KOR'이고 인구가 100만 이상 500만 이하인 도시
		static void query3(Connection con) throws Exception {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from city where countrycode = 'KOR' and population between 1000000 and 5000000;");
			ResultSetMetaData rsdm = rs.getMetaData();
			int count = rsdm.getColumnCount();
			
			System.out.println("=".repeat(80));
			System.out.println(rsdm.getTableName(1));
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
		}
	
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			query1(con);
			query2(con);
			query3(con);
			query(con, "select * from city where countrycode = 'KOR' and population >= 1000000;");
			query(con, "select * from city where countrycode = 'KOR' order by population desc limit 10;");
			query(con, "select * from city where countrycode = 'KOR' and population between 1000000 and 5000000;");
			
			con.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
