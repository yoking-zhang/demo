package org.yoking.pattern.pc.wn;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * The Class Producer.
 */
public class Producer implements Runnable {
	private static final Logger logger = Logger.getLogger(Producer.class);
	
	private List<Cake> plate;
	
	/**
	 * Instantiates a new producer.
	 *
	 * @param plate the plate
	 */
	public Producer(List<Cake> plate) {
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
				while (plate.size() >= PCDemo1.PLATE_SIZE) {
					try {
						plate.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Cake c = createCake();
				plate.add(c);
				logger.info(Thread.currentThread().getName() + " is producing cake " + c + ".");
				plate.notifyAll();
			}
		}
	}
	
	/**
	 * Creates the cake.
	 *
	 * @return the cake
	 */
	private Cake createCake() {
		long now = System.nanoTime();
		return new Cake().id(now).name("cake_" + now);
	}

}