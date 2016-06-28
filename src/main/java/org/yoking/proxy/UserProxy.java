package org.yoking.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserProxy implements InvocationHandler {

	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	private void before() {
		System.out.println("Executing before method...");
	}

	private void after() {
		System.out.println("Executing after method...");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}

}