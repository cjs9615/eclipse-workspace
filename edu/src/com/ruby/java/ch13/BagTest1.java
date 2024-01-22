package com.ruby.java.ch13;

class Bag1 {
	private Object thing;

	public Bag1(Object thing)	{
		this.thing = thing;
	}
	
	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}



public class BagTest1 {
	public static void main(String[] args) {
		Bag1 bag = new Bag1(new Book());
		Bag1 bag2 = new Bag1(new PencilCase());
		Bag1 bag3 = new Bag1(new Notebook());
		
		Book book = (Book) bag.getThing();
		PencilCase pc = (PencilCase) bag2.getThing();
		Notebook nb = (Notebook) bag3.getThing();
		
		bag = bag2;
	}
	
}
