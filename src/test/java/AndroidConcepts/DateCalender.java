package AndroidConcepts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalender {

	public static void main(String[] args) {
		
		
		Date d = new Date();
		System.out.println("Date coming is: "+ d.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyy hh:mm:ss");
		
		
		System.out.println("SimpleDateFormat coming is: "+ sdf.format(d));
		System.out.println("SimpleDateFormat coming in seconds are: "+ sdf2.format(d));
		
		java.util.Calendar cal= java.util.Calendar.getInstance();
		System.out.println("Calender getTime: "+ sdf2.format(cal.getTime()));
		System.out.println("Calender Dayofweek: "+ cal.get(java.util.Calendar.DAY_OF_WEEK));
		System.out.println("Calender DayofYear: "+ cal.get(java.util.Calendar.DAY_OF_YEAR));
		System.out.println("Calender WeekofMonth: "+ cal.get(java.util.Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("Calender WeekofMonth: "+ cal.get(java.util.Calendar.AM_PM));
		System.out.println("Calender HourofDay: "+ cal.get(java.util.Calendar.HOUR_OF_DAY));
		
		

	}

}
