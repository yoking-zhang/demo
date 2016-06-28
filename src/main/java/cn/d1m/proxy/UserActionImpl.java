package cn.d1m.proxy;

public class UserActionImpl implements UserAction {
	
	@Override
	public void addUser() {
		System.out.println("Saving User...");
	}
	
	@Override
	public void removeUser() {
		System.out.println("Removing User...");
	}
	
}