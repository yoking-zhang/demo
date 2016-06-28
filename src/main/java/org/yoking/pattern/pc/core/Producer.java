package org.yoking.pattern.pc.core;

import java.util.concurrent.BlockingQueue;

import org.yoking.pattern.pc.Cake;
import org.yoking.pattern.pc.Constants;

/**
 * Producer.
 * 
 * @author Yoking
 */
public class Producer implements Runnable {
	private String name;
	private BlockingQueue<Task> queue;

	public Producer(String name, BlockingQueue<Task> queue) {
		this.name = name;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			if (queue != null && queue.size() < Constants.DEFAULT_TASK_QUEUE_SIZE) {
				try {
					queue.put(produce());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Produce a task.
	 * 
	 * @return Task
	 */
	public Task produce() {
		Task c = new Cake();
		System.out.println(name + " is producing a " + c.getClass().getSimpleName() + " with ID: " + c.getSerialNumber());
		return c;
	}

}