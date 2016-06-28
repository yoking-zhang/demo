package org.yoking.pattern.pc.core;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer.
 * 
 * @author Yoking
 */
public class Consumer implements Runnable {
	private String name;
	private BlockingQueue<Task> queue;

	public Consumer(String name, BlockingQueue<Task> queue) {
		this.name = name;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (queue.size() > 0) {
					consume(queue.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Consume a task.
	 * 
	 * @param t
	 */
	public void consume(Task t) {
		System.out.println(name +  " is consuming a " + t.getClass().getSimpleName() + " with ID: " + t.getSerialNumber());
	}
}