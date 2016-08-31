package org.yoking.pattern.singleton;

public class S3 {
	private S3() {

	}

	public static final S3 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder {
		private static S3 INSTANCE = new S3();
	}

}