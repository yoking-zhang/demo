package org.yoking.proxy2;

public class CglibProxy {

	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
		service.print("Hello");
	}
}
