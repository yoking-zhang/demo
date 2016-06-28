package org.yoking.pattern.cmd.concrete;

import org.yoking.pattern.cmd.Command;
import org.yoking.pattern.cmd.receiver.DelReceiver;

/**
 * DELETE Command Concrete Class.
 * 
 * @author Yoking
 */
public class DelCommand implements Command {

	private DelReceiver del;

	public DelCommand() {
		this.del = new DelReceiver();
	}

	@Override
	public void execute() {
		del.delete();
	}

}
