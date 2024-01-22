package com.ruby.java.ch07.추상;

public interface Messenger {
	//String name;//필드 선언은 안됨
	int MIN_SIZE = 1;//final 상수 값 처리
	int MAX_SIZE = 104857600;//final
	
	public String getMessage();//추상 메소드 - abstract 사용하지 않음
	public void setMessage(String msg);
	public default void setLogin(boolean login) {
		System.out.println("로그인");
	}
	public static void getConnection() {
		System.out.println("정적 메소드");
	}
}
