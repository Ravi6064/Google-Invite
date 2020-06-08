import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8Dates2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LocalDate.now());

		System.out.println(LocalDate.now().plusDays(7));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");

		String s1 = "01/01/1970 08:00:00 PM";

		System.out.println(LocalTime.parse(s1, formatter).plusMinutes(60));

		System.out.println("---------------- ************** ------- ************ ----------");

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy
		// hh:mm:ss a");
		LocalTime storeOpenTime = LocalTime.parse("01/01/1970 07:39:00 PM", formatter);
		LocalTime slotsStartTime = null;
		LocalTime temp = null;

		temp = storeOpenTime.minusMinutes(30);

		System.out.println(temp);

		String s2 = temp.toString();
		String s[] = s2.split(":");

		if (Integer.parseInt(s[1]) >= 30) {
			slotsStartTime = temp.minusMinutes((Integer.valueOf(s[1]) - 30));
		} else {
			slotsStartTime = temp.minusMinutes(Integer.valueOf(s[1]));
		}

		System.out.println(slotsStartTime);

		System.out.println("---------------- ************** ------- ************ ----------");

		System.out.println(LocalTime.now().compareTo(LocalTime.now()));

		LocalDate date = LocalDate.now();

		LocalDate date2 = LocalDate.now().plusDays(7);

		//List<String> list = new ArrayList<>();
		Map<LocalDate,List<String>> map = new HashMap<>();
		for (int i = 0; i <= 7; i++) {
			LocalTime time = LocalTime.parse("01/01/1970 09:00:00 AM", formatter);
			LocalTime time2 = LocalTime.parse("01/01/1970 08:00:00 PM", formatter);
			List<String> list = new ArrayList<>();

			while (time.compareTo(time2) < 0) {
				list.add(LocalTime.of(time.getHour(), time.getMinute()).toString());
				time = time.plusMinutes(30);
			}
			map.put(date,list);
			date = date.plusDays(1);

		}

		//System.out.println(map);
		map.forEach((k,v)-> System.out.println(k+"    ********* "+v));
		System.out.println("****************** ---------- After Removing the WeekOff -------****** ");
		map.remove(LocalDate.now());
		
		map.forEach((k,v)-> System.out.println(k+"    ********* "+v));
		
		
		System.out.println(LocalDate.now().getDayOfWeek().toString().equalsIgnoreCase("tuesday"));
		
		
		System.out.println("****************** ---------- After Removing the WeekOff -------****** ");
		
		Map<Integer,String> map2 = new HashMap<>();
		map2.put(100, "Ravi");
		map2.put(101, "Kiran");
		map2.put(102, "Dhyan");
		
		map2.entrySet().removeIf(e ->
			e.getKey().equals(100));
		
		System.out.println(map2);
		
		System.out.println(LocalDate.now().compareTo(LocalDate.now()));

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		System.out.println(LocalTime.of(10,00));
		
		System.out.println(LocalTime.of(10, 00).equals(LocalTime.of(10, 30)));
	}

}
