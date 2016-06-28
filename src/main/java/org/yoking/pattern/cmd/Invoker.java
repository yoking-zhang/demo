package org.yoking.pattern.cmd;

public class Invoker {
	private Command cmd;

	public Command getCmd() {
		return cmd;
	}

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}

	public void onClick() {
		cmd.execute();
	}
	
}