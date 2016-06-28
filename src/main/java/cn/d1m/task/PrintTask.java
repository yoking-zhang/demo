package cn.d1m.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PrintTask extends TimerTask {

	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	
	@Override
	public void run() {
		Date now = new Date(System.currentTimeMillis());
		System.out.println("Task is executed at " + format.format(now));
	}

	public static void main(String[] args) {
		System.out.println(TimeUnit.MINUTES.toMillis(1));
	}
}