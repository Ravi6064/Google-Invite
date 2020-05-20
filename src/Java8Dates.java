import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Java8Dates {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();
		System.out.println(d);
		
		
		LocalTime t = LocalTime.now();
		System.out.println(t);
		
		
		Instant i = Instant.now();
		System.out.println(i);
		
		
		LocalDate d2 = LocalDate.of(2020,Month.OCTOBER,16);
		System.out.println(d2);
		
		LocalDateTime d3 = LocalDateTime.now(ZoneId.of("GMT"));
		System.out.println(d3);
		
		
		Date date = new Date();
		System.out.println(date);
		
		System.out.println(LocalDate.now().toString());
		
		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.addAll(Arrays.asList(10,20,20,40));
		
		System.out.println(list);

	}

}
