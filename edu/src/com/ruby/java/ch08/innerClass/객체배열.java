package com.ruby.java.ch08.innerClass;

public class 객체배열 {
	class Student {
		int sid;
		String sname;
		public Student() {}
		public Student(int sid, String sname){
			this.sid = sid;
			this.sname = sname;
		}
		@Override
		public String toString() {
			return "sid = " + sid + ", sname = " + sname;
		}
		void show(int num) {
			System.out.println("sset[" + num + "] :: " + this.toString());
		}
	}
	public static void main(String[] args) {
		객체배열 obj = new 객체배열();
	
		Student []sset = new Student[10];
		sset[0] = obj.new Student(10,"hong");
		sset[1] = obj.new Student(11,"kim");
		sset[2] = obj.new Student(12,"lee");
		for (int i = 0; i < 3; i++)
			sset[i].show(i);
	}
}

