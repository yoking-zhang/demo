package org.yoking.guava;

import com.google.common.base.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		String str = null;
		System.out.println(Optional.fromNullable(str).isPresent());
	}

}
