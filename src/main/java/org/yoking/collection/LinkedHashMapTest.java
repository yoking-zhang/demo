package org.yoking.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.yoking.vo.Gender;
import org.yoking.vo.User;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<Integer, User> cache = new LinkedHashMap<Integer, User>(16, 0.75f, true);

		List<User> users = generateTenUserList();
		for (User u : users) {
			cache.put(u.hashCode(), u);
		}
		
		print(cache);
		cache.get(users.get(5).hashCode());
		
		print(cache);
		cache.get(users.get(8).hashCode());
		
		print(cache);
		cache.get(users.get(2).hashCode());
		
		print(cache);
	}

	private static List<User> generateTenUserList() {
		List<User> users = new ArrayList<User>();

		for (long i = 0; i < 10; i++) {
			users.add(new User(i, "yoking_" + i + "@d1m.cn", "yoking_" + i, new char[] { '1', '2', '3' }, Gender.MALE));
		}

		return users;
	}
	
	private static void print(Map<Integer, User> cache) {
		Iterator<Entry<Integer, User>> it = cache.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, User> entry = it.next();
			System.out.print(entry.getValue().getNickName() + "\t");
		}
		System.out.println();
	}
	
}