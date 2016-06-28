package cn.d1m.nio.watcher;

import java.nio.file.WatchEvent.Kind;

public class FileSystemEvent {

	private String fileName;

	private Kind<?> kind;

	public FileSystemEvent(String fileName, Kind<?> kind) {
		this.fileName = fileName;
		this.kind = kind;
	}

	public String getFileName() {
		return fileName;
	}

	public Kind<?> getKind() {
		return kind;
	}

}