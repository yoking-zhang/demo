package cn.d1m.util;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		String str = "1:2:3:4:5";
		
		StringTokenizer st = new StringTokenizer(str, ":");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
