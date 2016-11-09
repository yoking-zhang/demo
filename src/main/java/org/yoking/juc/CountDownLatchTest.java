package org.yoking.juc;

import java.util.concurrent.CountDownLatch;

/**
 * The Class CountDownLatchTest.
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);

		System.out.println("Main thread is starting.");
		
		new Thread() {
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println("Thread " + threadName + " is starting.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread " + threadName + " is stopped.");
				latch.countDown();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println("Thread " + threadName + " is starting.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread " + threadName + " is stopped.");
				latch.countDown();
			}
		}.start();
		
		try {
			latch.await();
			System.out.println("waiting for two sub-thread completed.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("two sub-threads are stopped.");
		System.out.println("Main thread is stopped.");
	}

}
