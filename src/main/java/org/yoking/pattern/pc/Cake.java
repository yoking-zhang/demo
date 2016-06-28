package org.yoking.pattern.pc;

import java.util.UUID;

import org.yoking.pattern.pc.core.Task;

public class Cake implements Task {
	private static final long serialVersionUID = 4035446710112719437L;
	
	private String id;

	public Cake() {
		id = UUID.randomUUID().toString();
	}

	@Override
	public String getSerialNumber() {
		return id;
	}

}