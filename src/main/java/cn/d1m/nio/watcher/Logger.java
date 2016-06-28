package cn.d1m.nio.watcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

public class Logger implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		FileSystemEvent event = (FileSystemEvent)obj;
		System.out.printf("%s has been %s\n", event.getFileName(), event.getKind());
		
		Properties prop = new Properties();
		try {
			String fileName = event.getFileName();
			
			if(fileName.endsWith(".properties")) {
				prop.load(new FileReader(fileName));
				
				Enumeration<Object> keys = prop.keys();
				while(keys.hasMoreElements()) {
					String next = (String)keys.nextElement();
					System.out.println(next + "=" + prop.getProperty(next));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}