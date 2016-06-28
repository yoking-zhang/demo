package cn.d1m.nio.watcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * DirectoryWatcher is to indicate specified folder, whether there are some
 * changes of the files.
 * 
 * @author Yoking
 *
 */
public class DirectoryWatcher extends Observable {

	private WatchService watcher;

	private Path path;

	private WatchKey key;

	private Executor executor = Executors.newSingleThreadExecutor();
	
	private final Kind<?>[] kinds = { StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY };
	
	public DirectoryWatcher(String dir) throws IOException {
		watcher = FileSystems.getDefault().newWatchService();
		path = Paths.get(dir);
		key = path.register(watcher, kinds);
	}
	
	/** Start the Watcher service. */
	public void startup() {
		executor.execute(new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				processEvent();
				return Integer.valueOf(0);
			}
		}));
	}
	
	/** Shutdown the Watcher service. */
	public void shutdown() throws IOException {
		watcher.close();
		executor = null;
	}
	
	/** Notify file system event. */
	void processEvent() {
		while(true) {
			WatchKey signal;
			
			try {
				signal = watcher.take();
			} catch (InterruptedException e) {
				return;
			}
			
			for(WatchEvent<?> event : signal.pollEvents()) {
				Kind<?> kind = event.kind();
				
				if(kind == StandardWatchEventKinds.OVERFLOW) {
					continue;
				}
				
				Path name = (Path)event.context();
				notify(name.toAbsolutePath().toString(), kind);
			}
			
			key.reset();
		}
	}
	
	/** Notify the watcher with file event. */
	void notify(String fileName, Kind<?> kind) {
		setChanged();
		notifyObservers(new FileSystemEvent(fileName, kind));
	}
}
