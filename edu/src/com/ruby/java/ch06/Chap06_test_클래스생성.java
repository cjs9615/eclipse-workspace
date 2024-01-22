package com.ruby.java.ch06;
//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
class Student {
	 static int countStudents;//객체수
	 int sid;//학번
	 String sname; //학생 이름
	 String city; //주소 도시
	 public Student() {
		 countStudents++;
	 }
	 public Student(int sid) {
		 this(sid, null);
		 //countStudents++;
	 }
	 public Student(int sid, String sname) {
		 this(sid, sname, null);
		 //countStudents++;
	 }
	 public Student(int sid, String sname, String city) {
		 this.sid = sid; this.sname = sname; this.city = city;
		 countStudents++;
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
		 System.out.println("객체수는 " + countStudents);
	 }
}
public class Chap06_test_클래스생성 {
	static void show(Student a[]){
		//모든 객체를 출력한다
		 for(int i = 0; i < a.length; i++) {
			 a[i].showStudent();//생성된 객체 모두를 출력한다.
		 }
	}
	public static void main(String[] args) {
		 int [] a = new int [5];
		 Student arry[] = new Student[5];
		 Student.showNumberObjects();
		 arry[0] = new Student();
		 arry[1] = new Student(202301);
		 arry[2] = new Student(202302, "Hong");
		 arry[3] = new Student(202303, "Lee", "Busan");
		 arry[4] = new Student(202304, "Na", "jeju");
		 Student.showNumberObjects();		 
		 show(arry);
		 
	}
}

