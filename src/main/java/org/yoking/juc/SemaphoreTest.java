package org.yoking.juc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		int N = 9;
		Semaphore semaphore = new Semaphore(N/3);
		
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(semaphore)).start();
		}
	}

}

class Worker implements Runnable {
	private Semaphore semaphore;
	
	public Worker(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		
		try {
			semaphore.acquire();
			System.out.println("工人" + threadName + "占用一台机器生产...");
			Thread.sleep(3000);
			System.out.println("工人" + threadName + "生产完成, 空出机器...");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}