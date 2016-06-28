package org.yoking.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TaskRunner {

	public static void main(String[] args) {
		// Schedule time format, like 's m H d M'
		String schedule = "30 * * * *";
		TimePeriod tp = getTimePeriod(schedule);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new PrintTask(), tp.getStart(), tp.getPeriod());
	}

	private static TimePeriod getTimePeriod(String schedule) {
		String[] times = schedule.split(" ");
		Calendar cal = Calendar.getInstance();
		long period = 0;

		int sec, min, hour, day, month;
		try {
			sec = Integer.parseInt(times[0]);
			if (sec < 0 || sec > 60) {
				throw new IllegalArgumentException("Second of schedule time is badly set.");
			}
			int nowSec = cal.get(Calendar.SECOND);
			if(nowSec >= sec) {
				cal.add(Calendar.MINUTE, 1);
			}
			
			cal.set(Calendar.SECOND, sec);
			
			if (!"*".equals(times[1])) {
				min = Integer.parseInt(times[1]);
				if (min < 0 || min > 60) {
					throw new IllegalArgumentException("Minute of schedule time is badly set.");
				}
				int nowMin = cal.get(Calendar.MINUTE);
				if(nowMin > min) {
					cal.add(Calendar.HOUR_OF_DAY, 1);
				}
				cal.set(Calendar.MINUTE, min);
			}

			if (!"*".equals(times[2])) {
				hour = Integer.parseInt(times[2]);
				if (hour < 0 || hour > 23) {
					throw new IllegalArgumentException("Hour of schedule time is badly set.");
				}
				int nowHour = cal.get(Calendar.HOUR_OF_DAY);
				if(nowHour > hour) {
					cal.add(Calendar.DAY_OF_MONTH, 1);
				}
				cal.set(Calendar.HOUR_OF_DAY, hour);
			}

			if (!"*".equals(times[3])) {
				day = Integer.parseInt(times[3]);
				if (day < 0 || day > 31) {
					throw new IllegalArgumentException("Day of schedule time is badly set.");
				}
				int nowDay = cal.get(Calendar.DAY_OF_MONTH);
				if(nowDay > day) {
					cal.add(Calendar.MONTH, 1);
				}
				cal.set(Calendar.DAY_OF_MONTH, day);
			}

			if (!"*".equals(times[4])) {
				month = Integer.parseInt(times[4]);
				if (month < 0 || month > 12) {
					throw new IllegalArgumentException("Month of schedule time is badly set.");
				}
				int nowMonth = cal.get(Calendar.MONTH);
				if(nowMonth > month - 1) {
					cal.add(Calendar.YEAR, 1);
				}
				cal.set(Calendar.MONTH, month-1);
			}
			
			if("*".equals(times[1])) {
				period = TimeUnit.MINUTES.toMillis(1);
			} else if("*".equals(times[2])) {
				period = TimeUnit.HOURS.toMillis(1);
			} else if("*".equals(times[3])) {
				period = TimeUnit.DAYS.toMillis(1);
			} else if("*".equals(times[4])) {
				int days = cal.get(Calendar.DAY_OF_MONTH);
				period = TimeUnit.DAYS.toMillis(1) * days;
			}
		} catch (NumberFormatException e) {
			System.out.println("Set second of sechdule time.");
		}

		return new TimePeriod(cal.getTime(), period);
	}

}

class TimePeriod {
	private Date start;
	private long period;

	public TimePeriod(Date start, long period) {
		this.start = start;
		this.period = period;
	}

	public Date getStart() {
		return start;
	}

	public long getPeriod() {
		return period;
	}
}