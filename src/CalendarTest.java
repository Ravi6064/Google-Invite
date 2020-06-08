import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String firstDate = "26/02/2019";
		String firstTime = "11:00 AM";
		String secondDate = "26/02/2019";
		String secondTime = "07:00 PM";

			Calendar cal = Calendar.getInstance();
			System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			cal.add(Calendar.DATE, 7);
			System.out.println(new Date(cal.getTimeInMillis()));
			String s1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(cal.getTimeInMillis()));
			//System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			System.out.println(s1);
			String format = "dd/MM/yyyy hh:mm a";
			SimpleDateFormat sdf = new SimpleDateFormat(format);


	}

}
