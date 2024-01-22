package edu.pnu;

public class DriverLoading {
	public static void main(String[] args) {
		
		try {
			String diver = "com.mysql.cj.jdbc.Driver";
			
			Class.forName(diver);
			
			System.out.println("로딩 성공");
			
		}catch (Exception e) {
			System.out.println("로딩실패 : " + e.getMessage());
		}
	}
}
