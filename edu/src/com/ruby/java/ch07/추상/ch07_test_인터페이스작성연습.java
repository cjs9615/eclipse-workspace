package com.ruby.java.ch07.추상;

/*
//interface는 자바 파일로 만들어야 
public interface Shape {
	public float perimeter();
	public float area();
}
*/
class Triangle implements Shape {
	private int x1,y1,x2,y2,x3,y3;
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.x3 = x3; this.y3 = y3;
	}
	public double perimeter() {
		double sum = 0;
		sum = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)) + Math.sqrt(Math.pow((x1-x3),2)+Math.pow((y1-y3),2)) + Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3),2)) ;
		return sum;
	}
	public double area() {
		double area = 0;
		area = Math.abs((x1*y2 + x2*y3 + x3*y1) - (x1*y3 + x3*y2 + x2*y1))*0.5; 
		return area;
	}
}
class Rectangle implements Shape {
	int x1,y1,x2,y2;
	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1; this.y1 = y1; this.x2 = x2 ; this.y2 = y2;
	}
	public double perimeter() {
		double sum = 0;
		sum = (Math.abs(x1-x2) + Math.abs(y1-y2))*2;
		return sum;
	}
	public double area() {
		double area = 0;
		area = Math.abs((x1-x2) * (y1-y2));
		return area;
	}
	
}
class Square implements Shape {
	int x1, y1;
	int side;
	public Square(int x1, int y1, int side) {
		this.x1 = x1; this.y1 = y1; this.side = side;
	}
	public double perimeter() {
		double sum = 0;
		sum = side*4;
		return sum;
	}
	public double area() {
		double area = 0;
		area = Math.pow(side, 2);
		return area;
	}
}
public class ch07_test_인터페이스작성연습 {
	public static void main(String[] args) {
		Shape t = new Triangle(1,3,3,1,3,3);
		Shape r = new Rectangle(1,2,3,4);
		Shape s = new Square(1,2,3);
		System.out.println("삼각형 둘레 길이 = " + t.perimeter());
		System.out.println("삼각형 면적 = " + t.area());
		System.out.println("사각형 둘레 길이 = " + r.perimeter());
		System.out.println("사각형 면적 = " + r.area());
		System.out.println("정사각형 둘레 길이 = " + s.perimeter());
		System.out.println("정사각형 면적 = " + s.area());
	}
}
