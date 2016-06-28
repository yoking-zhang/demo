package cn.d1m.pattern.cmd.concrete;

import cn.d1m.pattern.cmd.Command;
import cn.d1m.pattern.cmd.receiver.AddReceiver;

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
