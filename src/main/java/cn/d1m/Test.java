package cn.d1m;


public class Test {

	public static void main(String[] args) {
		System.out.println(Test.class.getClassLoader().getResource(".").getPath());
	}
}