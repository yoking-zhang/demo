package org.yoking.proxy;

import java.lang.reflect.Proxy;

public class ProxyApp {

	public static void main(String[] args) {
		UserAction action = new UserActionImpl();
		UserProxy proxy = new UserProxy();
		proxy.setTarget(action);

		UserAction proxyAction = (UserAction) Proxy.newProxyInstance(UserAction.class.getClassLoader(), new Class[] { UserAction.class }, proxy);
		proxyAction.addUser();
		
		proxyAction.removeUser();
	}
}
