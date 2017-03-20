package org.yoking.ref;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.yoking.vo.Gender;
import org.yoking.vo.User;

public class SoftRef {

	public static void main(String[] args) {
		User user = new User(1l, "yoking.zhang@d1m.cn", "yoking", new char[] { '1', '2', '3', '4', '5', '6' }, Gender.MALE);

		ReferenceQueue<User> queue = new ReferenceQueue<User>();
		SoftReference<User> sr = new SoftReference<User>(user, queue);

		user = null;
		PrintWriter w = null;
		try {
			w = new PrintWriter("d:/ref.txt");

			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				w.println(sr.get());
				System.gc();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (w != null) {
				w.close();
			}
		}
	}
}
