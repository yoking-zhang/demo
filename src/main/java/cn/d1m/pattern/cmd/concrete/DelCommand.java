package cn.d1m.pattern.cmd.concrete;

import cn.d1m.pattern.cmd.Command;
import cn.d1m.pattern.cmd.receiver.DelReceiver;

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
