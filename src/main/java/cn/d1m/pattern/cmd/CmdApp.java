package cn.d1m.pattern.cmd;

import cn.d1m.pattern.cmd.concrete.AddCommand;
import cn.d1m.pattern.cmd.concrete.DelCommand;

/**
 * Hello world!
 *
 */
public class CmdApp {
	
	public static void main(String[] args) {
		Command add = new AddCommand();
		Command del = new DelCommand();
		
	
		Invoker invoke = new Invoker();
		invoke.setCmd(add);
		invoke.onClick();
		
		invoke.setCmd(del);
		invoke.onClick();
	}
}
