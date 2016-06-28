package org.yoking.pattern.pc1;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {
	private static final Logger logger = Logger.getLogger(Consumer.class);
	
	private List<Cake> plate;
	
	/**
	 * Instantiates a new consumer.
	 *
	 * @param plate the plate
	 */
	public Consumer(List<Cake> plate) {
		this.plate = plate;
	}
	
	/** 
	 * {@inheritDoc}
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			synchronized (plate) {
				while (plate.size() == 0) {
					try {
						plate.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Cake c = plate.remove(plate.size() - 1);
				logger.info(c + " is consumed by " + Thread.currentThread().getName());
				plate.notifyAll();
			}
		}
	}

}