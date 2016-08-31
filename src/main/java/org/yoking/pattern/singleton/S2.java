package org.yoking.pattern.singleton;
/**
 * Singleton class with double check.
 * 
 * @author YY
 */
public class S2 {
	private volatile static S2 INSTANCE = null;
	
	private S2() {
		
	}
	
	public static final S2 getInstance() {
		if (INSTANCE == null) {
			synchronized (S2.class) {
				if (INSTANCE == null) {
					INSTANCE = new S2();
				}
			}
		}
		return INSTANCE;
	}
}
