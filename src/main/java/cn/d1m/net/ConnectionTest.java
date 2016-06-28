package cn.d1m.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:9090/ccfe/users/57620400b257e356f9853084");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			con.connect();
			
			int status = con.getResponseCode();
			System.out.println("Response status: " + status);
			
			InputStream in = con.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			
			StringBuffer buffer = new StringBuffer();
			byte[] buf = new byte[1024];
			while(bis.read(buf) != -1) {
				buffer.append(new String(buf));
			}
			
			System.out.println(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}