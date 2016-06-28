package org.yoking.nio.watcher;

import java.io.IOException;

public class FilePathListener {

	private static final String USER_PATH = System.getProperty("user.dir");

	public static void main(String[] args) throws IOException {
		DirectoryWatcher watcher = new DirectoryWatcher(USER_PATH);
		Logger logger = new Logger();

		watcher.addObserver(logger);
		watcher.startup();
	}

}