package com.ruby.java.ch08.innerClass;
/*
class GalaxyMessenger implements Messenger {
	public String getMessage() {
		return "galaxy";
	}
	
	public void setMessage(String msg) {
		System.out.println("galaxy에서 메시지를 설정합니다 : " + msg);
	}
	
	public void chanageKeyboard() {
		System.out.println("키보드아이콘 터치후 키보드를 변경합니다.");
	}
}
*/
public class MessengerTest {
	public static void main(String[] args) {
		Messenger test = new Messenger() {
			public String getMessage() {
				return "galaxy";
			}
			
			public void setMessage(String msg) {
				System.out.println("galaxy에서 메시지를 설정합니다 : " + msg);
			}
		};	
		
		//GalaxyMessenger galaxy = new GalaxyMessenger();
		test.getMessage();
		test.setMessage("hi");
		//test.chanageKeyboard();
	}
}
