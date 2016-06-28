package org.yoking.pattern.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yoking.pattern.pc.core.Consumer;
import org.yoking.pattern.pc.core.Producer;
import org.yoking.pattern.pc.core.Task;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>(Constants.DEFAULT_TASK_QUEUE_SIZE);
		
		Runnable p1 = new Producer("P1", queue);
		Runnable p2 = new Producer("P2", queue);
		Runnable c1 = new Consumer("C1", queue);
		Runnable c2 = new Consumer("C2", queue);
		
		new Thread(p1).start();
		new Thread(c1).start();
		new Thread(p2).start();
		new Thread(c2).start();
	}
}
