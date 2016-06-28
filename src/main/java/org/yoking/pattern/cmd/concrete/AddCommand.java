package org.yoking.pattern.cmd.concrete;

import org.yoking.pattern.cmd.Command;
import org.yoking.pattern.cmd.receiver.AddReceiver;

/**
 * ADD command concrete class.
 * 
 * @author Yoking
 */
public class AddCommand implements Command {

	private AddReceiver add;
	
	public AddCommand() {
		this.add = new AddReceiver();
	}
	
	@Override
	public void execute() {
		add.add();
	}

}
