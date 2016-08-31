package org.yoking.pattern.pc.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yoking.pattern.pc.bq.core.Producer;
import org.yoking.pattern.pc.bq.core.Task;
import org.yoking.pattern.pc.bq.core.Consumer;

/**
 * Hello world!.
 *
 */
public class App {
	public static final int DEFAULT_TASK_QUEUE_SIZE = 10;
	
	public static void main(String[] args) {
		BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>(DEFAULT_TASK_QUEUE_SIZE);
		
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
