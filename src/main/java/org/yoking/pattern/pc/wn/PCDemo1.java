package org.yoking.pattern.pc.wn;

import java.util.LinkedList;
import java.util.List;

/**
 * Producer-Consumer pattern demo 1.
 */
public class PCDemo1 {
	public static final int PLATE_SIZE = 20;
	
	public static void main(String[] args) {
		List<Cake> plate = new LinkedList<Cake>();
		new Thread(new Producer(plate)).start();
		new Thread(new Producer(plate)).start();
		new Thread(new Consumer(plate)).start();
		new Thread(new Consumer(plate)).start();
	}

}