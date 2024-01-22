package com.ruby.java.ch07.추상;

public class MessengerTest {
	public static void main(String[] args) {
		
		IPhoneMessenger iphone = new IPhoneMessenger();
		iphone.setLogin(false);
		iphone.getMessage();
		iphone.setMessage(null);
		Messenger.getConnection();
		
	}
}
