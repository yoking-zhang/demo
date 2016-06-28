package cn.d1m.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

	public static void main(String[] args) {
		ChannelTest ct = new ChannelTest();
//		ct.fileCopyThroughBuffer("E:\\A_Softwares\\Network\\Warcraft III.zip", "D:\\Warcraft III_tmp.zip");
		ct.fileCopy("E:\\A_Softwares\\Network\\Warcraft III.zip", "D:\\Warcraft III_tmp.zip");
	}
	
	/**
	 * Copy the file content from source file to destination file.
	 *
	 * @param from the from
	 * @param to the to
	 */
	public void fileCopyThroughBuffer(String source, String destination) {
		RandomAccessFile sf = null, df = null;
		
		try {
			sf = new RandomAccessFile(source, "r");
			df = new RandomAccessFile(destination, "rw");

			FileChannel fic = sf.getChannel();
			FileChannel foc = df.getChannel();

			long start = System.currentTimeMillis();
			ByteBuffer buf = ByteBuffer.allocate(1024 * 1024 * 10);
			while (fic.read(buf) >= 0 && buf.position() != 0) {
				buf.flip();
				foc.write(buf);
				buf.compact();
			}
			
			long end = System.currentTimeMillis();
			System.out.println("Copy time cost: " + (end - start) + " ms.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sf != null) {
					sf.close();
				}
				if (df != null) {
					df.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileCopy(String src, String dest) {
		RandomAccessFile sf = null, df = null;
		try {
			sf = new RandomAccessFile(src, "rw");
			df = new RandomAccessFile(dest, "rw");

			FileChannel fic = sf.getChannel();
			FileChannel foc = df.getChannel();

			long position = 0;
			long size = fic.size();
			long length = fic.transferTo(position, size, foc);
			System.out.println("file length: " + length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sf != null) {
					sf.close();
				}
				if (df != null) {
					df.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}