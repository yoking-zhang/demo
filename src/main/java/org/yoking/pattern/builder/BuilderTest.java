package org.yoking.pattern.builder;

import java.util.Date;

import org.yoking.pattern.builder.Car.Builder;

public class BuilderTest {

	public static void main(String[] args) {
		Car c = new Builder().id(123l).color(Color.WHITE).manufacturer("SAIC-GM").date(new Date()).build();
		System.out.println(c);
	}

}