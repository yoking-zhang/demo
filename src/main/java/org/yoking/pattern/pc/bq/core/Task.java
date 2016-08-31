package org.yoking.pattern.pc.bq.core;

import java.io.Serializable;

/**
 * Task for produce and consume.
 * 
 * @author Yoking
 */
public interface Task extends Serializable {
	
	String getSerialNumber();
}