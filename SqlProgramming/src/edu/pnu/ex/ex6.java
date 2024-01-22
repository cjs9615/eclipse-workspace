package edu.pnu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

class Countrylanguage{
	String countrycode;
	String language;
	String isofficial;
	double percentage;
	
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIsofficial() {
		return isofficial;
	}
	public void setIsofficial(String isofficial) {
		this.isofficial = isofficial;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return "countrylanguage [countrycode=" + countrycode + ", language=" + language + ", isofficial=" + isofficial
				+ ", percentage=" + percentage + "]";
	}
	
}

public class ex6 {
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
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			show_query(con, "select Language, IsOfficial, percentage from countrylanguage cl where exists (select * from country c where cl.countryCode = c.code and c.code='KOR');");			
			show_query(con, "select language, isofficial, Percentage from country c join countrylanguage cl on cl.CountryCode = c.code and c.Code = 'KOR';");
			show_query(con, "select language, IsOfficial, percentage from country c, countrylanguage cl where c.Code = cl.CountryCode and c.code = 'KOR';");
			
			
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
