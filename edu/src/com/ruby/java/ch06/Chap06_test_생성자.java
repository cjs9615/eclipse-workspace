package com.ruby.java.ch06;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */

public class Chap06_test_생성자 {
	 static int countStudents;//객체수
	 int sid;//학번
	 String sname; //학생 이름
	 String city; //주소 도시
	 public Chap06_test_생성자(int sid, String name, String city) {
		 this.sid = sid; this.sname = sname; this.city = city;
	 }
	 void showStudent() {
		 System.out.print("객체: ");
		 System.out.println(this.toString());
	 }
	 @Override
	 public String toString() {
		 return "Student [sid=" + sid + ", sname=" + sname + ", city=" + city + "]";
	 }
	 static void showNumberObjects() {//생성된 객체수를 출력한다.
		 
	 }
	 // 생성자 구현한다.
	 public static void main(String[] args) {
		 countStudents = 0;
		 
		 //sid = 0;
		 Chap06_test_생성자 s = new Chap06_test_생성자(11, "hong", "busan");
		 s.sid = 10;
		 
		 int [] a = new int [5];
		 Student arry[] = new Student[5];
		 showNumberObjects();
		 arry[0] = new Student();
		 arry[1] = new Student(202301);
		 arry[2] = new Student(202302, "Hong");
		 arry[3] = new Student(202303, "Lee", "Busan");
		 showNumberObjects();
		 for(int i = 0; i < arry.length; i ++) {
			 arry[i].showStudent();//생성된 객체 모두를 출력한다.
		 }
	 }
}
