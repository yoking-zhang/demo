package cn.d1m.nio.charset;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

public class CharsetTest {

	public static void main(String[] args) {
		displaySupportedCharsets();
	}

	/**
	 * Display supported char sets.
	 */
	public static void displaySupportedCharsets() {
		Map<String, Charset> map = Charset.availableCharsets();
		for(Entry<String, Charset> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue().displayName());
		}
	}
}
