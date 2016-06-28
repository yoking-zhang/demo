package cn.d1m.ref;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import cn.d1m.vo.User;

public class SoftRef {

	public static void main(String[] args) {
		User user = new User(1l, "yoking.zhang@d1m.cn", "yoking", new char[] { '1', '2', '3', '4', '5', '6' });

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
