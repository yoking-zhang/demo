package org.yoking.proxy2;

public class UserServiceImpl extends UserService {

	private void before() {
		System.out.println("doing something before...");
	}
	
	private void after() {
		System.out.println("doing something after...");
	}
	
	@Override
	public void print(String message) {
		this.before();
		super.print(message);
		this.after();
	}

}