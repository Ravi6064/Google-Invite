import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ZonedDateTime.now(ZoneId.systemDefault()));
		
		System.out.println(LocalDateTime.now());
		
		/*
		 * DTSTART:20200608T193500 DTEND:20200608T200500 LOCATION:localtion UID:test
		 * DTSTAMP:20200608T193500
		 */
	}

}
