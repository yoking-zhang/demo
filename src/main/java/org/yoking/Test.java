package org.yoking;


public class Test {

	public static void main(String[] args) {
		System.out.println(Test.class.getClassLoader().getResource(".").getPath());
	}
}