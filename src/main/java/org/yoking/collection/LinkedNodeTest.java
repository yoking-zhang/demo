package org.yoking.collection;

import java.util.ArrayList;
import java.util.List;

import org.yoking.vo.User;

public class LinkedNodeTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		for (int i = 1; i <= 10; i++) {
			users.add(new User(i, "yoking_" + i + "@d1m.cn", "yoking_" + i, new char[] { '1', '2', '3' }));
		}

		LinkedNode<User> link = new LinkedNode<User>(users);
		link.printLinkedNode();
		
//		link.reverse();
//		link.printLinkedNode();
		
		link.reverseInRecursion();
		link.printLinkedNode();
	}
	
}