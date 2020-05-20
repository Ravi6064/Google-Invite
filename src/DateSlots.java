import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSlots {

	public static void main(String[] args) throws ParseException {

		String firstDate = "26/02/2019";
		String firstTime = "11:00 AM";
		String secondDate = "26/02/2019";
		String secondTime = "07:00 PM";

		for (int i = 0; i < 8; i++) {
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			cal.add(Calendar.DATE, i);
			System.out.println(new Date(cal.getTimeInMillis()));
			String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date(cal.getTimeInMillis()));
			//System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			String format = "dd/MM/yyyy hh:mm a";
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			//String s2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date(cal.getTimeInMillis()));

			Date dateObj1 = sdf.parse(s1 + " " + firstTime);
			Date dateObj2 = sdf.parse(s1 + " " + secondTime);
			//System.out.println("Date Start: " + dateObj1);
			//System.out.println("Date End: " + dateObj2);

			long dif = dateObj1.getTime();
			System.out.println("Day Slots "+s1);
			while (dif < dateObj2.getTime()) {
				Date slot = new Date(dif);
				System.out.println("Hour Slot --->" + new SimpleDateFormat("hh:mm a").format(slot));
				dif += 1800000;
			}
		}
	}

}
