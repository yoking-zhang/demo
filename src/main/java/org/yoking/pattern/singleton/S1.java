package org.yoking.pattern.singleton;

/**
 * Singleton class with single check.
 * 
 * @author YY
 */
public class S1 {
	private static S1 INSTANCE = null;

	private S1() {

	}

	public static final S1 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new S1();
		}
		return INSTANCE;
	}

}