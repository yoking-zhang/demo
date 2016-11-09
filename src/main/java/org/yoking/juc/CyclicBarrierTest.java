package org.yoking.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N + 1);
		for (int i = 0; i < N; i++) {
			new Thread(new Writer(barrier)).start();
		}

		String threadName = Thread.currentThread().getName();
		try {
			System.out.println(threadName + "等待其他子线程任务执行完毕...");
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("所有线程任务完成, " + threadName + "继续执行任务...");
	}
}

class Writer implements Runnable {
	private CyclicBarrier barrier;

	public Writer(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + "开始写入数据...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + "数据写入完毕, 等待其他线程...");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}