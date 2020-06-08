import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test {

	public static void main(String[] args) {

		/*
		 * LocalTime storeOpenTime = null; String tempStoreOpenTime =
		 * "01/01/1970 23:00:00 PM"; String s[] = tempStoreOpenTime.split(" ");
		 * 
		 * StringBuffer sb = new StringBuffer(s[1]); int value =
		 * Integer.valueOf(sb.substring(0, 2)); if(value - 12 > 0) { sb.delete(0, 2);
		 * s[1] = value-12<10 ?
		 * "0"+String.valueOf(value-12)+sb:String.valueOf(value-12)+sb;
		 * tempStoreOpenTime = String.valueOf(s[0]+" "+s[1]+" "+s[2]); } storeOpenTime =
		 * LocalTime.parse(tempStoreOpenTime.replace(" PM", ""),
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		 * 
		 * System.out.println(storeOpenTime);
		 */
		
		String s1="08:00 PM";
		System.out.println(LocalTime.parse(s1, DateTimeFormatter.ofPattern("hh:mm a")).format(DateTimeFormatter.ofPattern("hh:mm a")));
		System.out.println(LocalTime.now().toString());
		
		String s2 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
				"<head>\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
				"<meta\n" + 
				"	content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=no;\"\n" + 
				"	name=\"viewport\"/>\n" + 
				"<title>email</title>\n" + 
				"<style type=\"text/css\">\n" + 
				"body {\n" + 
				"	margin: 0;\n" + 
				"	padding: 0;\n" + 
				"	font-family: Arial, sans-serif, 'Helvetica Neue', Helvetica, Helvetica,\n" + 
				"		sans-serif;\n" + 
				"}\n" + 
				"\n" + 
				"a {\n" + 
				"	border: 0px;\n" + 
				"	text-decoration: none !important;\n" + 
				"	outline: 0px !important;\n" + 
				"}\n" + 
				"\n" + 
				"@media only screen and (max-width:599px) {\n" + 
				"	img[class=\"fullwidth\"] {\n" + 
				"		width: 100% !important;\n" + 
				"		height: auto !important;\n" + 
				"	}\n" + 
				"	table[class=\"fullwidth\"] {\n" + 
				"		width: 100% !important;\n" + 
				"	}\n" + 
				"	table[class=\"fullwidth90\"] {\n" + 
				"		width: 90% !important;\n" + 
				"	}\n" + 
				"}\n" + 
				"</style>\n" + 
				"</head>\n" + 
				"\n" + 
				"<body bgcolor=\"#cfcfcf\">\n" + 
				"	<table class=\"fullwidth\" width=\"600\" align=\"center\" cellpadding=\"0\"\n" + 
				"		cellspacing=\"0\" bgcolor=\"#ffffff\" style=\"border: 1px solid #191818\">\n" + 
				"		<tr>\n" + 
				"			<td colspan=\"3\" align=\"left\" valign=\"Top\"\n" + 
				"				style=\"font-size: 0; line-height: 0\"><table width=\"600\"\n" + 
				"					border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" + 
				"					class=\"fullwidth\" bgcolor=\"#d8d9db\">\n" + 
				"\n" + 
				"\n" + 
				"					<tr>\n" + 
				"						<td align=\"left\" valign=\"top\" style=\"font-size: 0; line-height: 0\">\n" + 
				"							<img\n" + 
				"							src=\"https://communications.airtel.com:8082/PromoCommunication/ExportImage?img=494_logo ribbon.jpg\"\n" + 
				"							alt=\"Airtel\" class=\"fullwidth\" style=\"display: block;\" /></a>\n" + 
				"						</td>\n" + 
				"					</tr>\n" + 
				"				</table></td>\n" + 
				"		</tr>\n" + 
				"\n" + 
				"\n" + 
				"		<tr>\n" + 
				"			<td align=\"left\" valign=\"top\"><table width=\"600\" border=\"0\"\n" + 
				"					cellspacing=\"0\" cellpadding=\"0\" align=\"center\" bgcolor=\"#ebebeb\"\n" + 
				"					class=\"fullwidth\">\n" + 
				"\n" + 
				"					<tr>\n" + 
				"						<td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\"\n" + 
				"								cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" + 
				"								class=\"fullwidth90\">\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"								<tr>\n" + 
				"									<td>\n" + 
				"										<table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n" + 
				"											align=\"center\" class=\"fullwidth\" bgcolor=\"#ebebeb\">\n" + 
				"\n" + 
				"\n" + 
				"											<tr>\n" + 
				"												<td align=\"left\" valign=\"middle\"\n" + 
				"													style=\"font-family: Arial, sans-serif, 'Helvetica Neue', Helvetica; font-size: 14px; line-height: 20px; color: #1b1b1b;\">Hello\n" + 
				"													%(customername),<br /> Greetings from Airtel!\n" + 
				"												</td>\n" + 
				"											</tr>\n" + 
				"\n" + 
				"											<tr>\n" + 
				"												<td align=\"left\" valign=\"middle\"\n" + 
				"													style=\"font-family: Arial, sans-serif, 'Helvetica Neue', Helvetica; font-size: 14px; line-height: 20px; color: #1b1b1b;\"><br />\n" + 
				"													Thank you for making your booking at the Airtel Store.<br />\n" + 
				"												<br /> Your booking details:<br /> Date: %(appointmentdate)<br /> Time:\n" + 
				"													%(appointmenttime)<br /> Duration: %(appointmentduration) minutes<br /> To discuss:\n" + 
				"													%(customerbookingdetails)<br /> Booking Reference: %(customerbookingref)<br /> Venue: %(storelocation)<br />\n" + 
				"													Click here for a Map: %(storelocationinmap)<br />\n" + 
				"												<br /> We look forward to seeing you.<br /></td>\n" + 
				"\n" + 
				"											</tr>\n" + 
				"											<tr>\n" + 
				"												<td height=\"30\" style=\"line-height: 0px; font-size: 0px\"></td>\n" + 
				"											</tr>\n" + 
				"\n" + 
				"											<tr>\n" + 
				"\n" + 
				"												<td align=\"left\" valign=\"middle\"\n" + 
				"													style=\"font-family: Arial, sans-serif, 'Helvetica Neue', Helvetica; font-size: 14px; line-height: 18px; color: #1b1b1b;\">Warm\n" + 
				"													Regards,<br /> Team Airtel\n" + 
				"												</td>\n" + 
				"												<br />\n" + 
				"												<br />\n" + 
				"\n" + 
				"												<tr>\n" + 
				"													<td height=\"10\" style=\"line-height: 0px; font-size: 0px\"></td>\n" + 
				"												</tr>\n" + 
				"\n" + 
				"										</table>\n" + 
				"									</td>\n" + 
				"								</tr>\n" + 
				"\n" + 
				"							</table></td>\n" + 
				"					</tr>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"				</table></td>\n" + 
				"		</tr>\n" + 
				"		<tr>\n" + 
				"			<td height=\"5\"\n" + 
				"				style=\"line-height: 5px; font-size: 0; background-color: #ee1c25\"></td>\n" + 
				"		</tr>\n" + 
				"	</table>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		
		
		  Map<String, Object> mapRequest = new HashMap<String, Object>();
		  
		  mapRequest.put("customername", "Ravikiran");
		  mapRequest.put("appointmentdate", "2020-06-06");
		  mapRequest.put("appointmenttime", "11:30 AM");
		  mapRequest.put("appointmentduration", "30");
		  mapRequest.put("customerbookingdetails", "sim exchange");
		  mapRequest.put("customerbookingref", "B0123");
		  mapRequest.put("storelocation", "ATP"); mapRequest.put("storelocationmap",
		  "http://");
		 

		String finalXMLRequest = StringEscapeUtils.unescapeHtml4(s2);


		StrSubstitutor substitutor = new StrSubstitutor(mapRequest, "%(", ")");
		System.out.println(substitutor.replace(finalXMLRequest));
		
		/*
		 * System.out.println(StringEscapeUtils.
		 * unescapeHtml4("&lt;!DOCTYPE html PUBLIC &quot;-//W3C//DTD XHTML 1.0 Transitional//EN&quot; &quot;http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd&quot;&gt;\n"
		 * + "&lt;html xmlns=&quot;http://www.w3.org/1999/xhtml&quot;&gt;\n" +
		 * "&lt;head&gt;\n" +
		 * "&lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=utf-8&quot; /&gt;\n"
		 * + "&lt;meta\n" +
		 * "content=&quot;width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=no;&quot;\n"
		 * + "name=&quot;viewport&quot;/&gt;\n" + "&lt;title&gt;email&lt;/title&gt;\n" +
		 * "&lt;style type=&quot;text/css&quot;&gt;\n" + "body {\n" + "margin: 0;\n" +
		 * "padding: 0;\n" +
		 * "font-family: Arial, sans-serif, &apos;Helvetica Neue&apos;, Helvetica, Helvetica,\n"
		 * + "sans-serif;\n" + "}\n" + "\n" + "a {\n" + "border: 0px;\n" +
		 * "text-decoration: none !important;\n" + "outline: 0px !important;\n" + "}\n"
		 * + "\n" + "@media only screen and (max-width:599px) {\n" +
		 * "img[class=&quot;fullwidth&quot;] {\n" + "width: 100% !important;\n" +
		 * "height: auto !important;\n" + "}\n" +
		 * "table[class=&quot;fullwidth&quot;] {\n" + "width: 100% !important;\n" +
		 * "}\n" + "table[class=&quot;fullwidth90&quot;] {\n" +
		 * "width: 90% !important;\n" + "}\n" + "}\n" + "&lt;/style&gt;\n" +
		 * "&lt;/head&gt;\n" + "\n" + "&lt;body bgcolor=&quot;#cfcfcf&quot;&gt;\n" +
		 * "&lt;table class=&quot;fullwidth&quot; width=&quot;600&quot; align=&quot;center&quot; cellpadding=&quot;0&quot;\n"
		 * +
		 * "cellspacing=&quot;0&quot; bgcolor=&quot;#ffffff&quot; style=&quot;border: 1px solid #191818&quot;&gt;\n"
		 * + "&lt;tr&gt;\n" +
		 * "&lt;td colspan=&quot;3&quot; align=&quot;left&quot; valign=&quot;Top&quot;\n"
		 * +
		 * "style=&quot;font-size: 0; line-height: 0&quot;&gt;&lt;table width=&quot;600&quot;\n"
		 * +
		 * "border=&quot;0&quot; cellspacing=&quot;0&quot; cellpadding=&quot;0&quot; align=&quot;center&quot;\n"
		 * + "class=&quot;fullwidth&quot; bgcolor=&quot;#d8d9db&quot;&gt;\n" + "\n" +
		 * "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;top&quot; style=&quot;font-size: 0; line-height: 0&quot;&gt;\n"
		 * + "&lt;img\n" +
		 * "src=&quot;https://communications.airtel.com:8082/PromoCommunication/ExportImage?img=494_logo ribbon.jpg&quot;\n"
		 * +
		 * "alt=&quot;Airtel&quot; class=&quot;fullwidth&quot; style=&quot;display: block;&quot; /&gt;&lt;/a&gt;\n"
		 * + "&lt;/td&gt;\n" + "&lt;/tr&gt;\n" + "&lt;/table&gt;&lt;/td&gt;\n" +
		 * "&lt;/tr&gt;\n" + "\n" + "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;top&quot;&gt;&lt;table width=&quot;600&quot; border=&quot;0&quot;\n"
		 * +
		 * "cellspacing=&quot;0&quot; cellpadding=&quot;0&quot; align=&quot;center&quot; bgcolor=&quot;#ebebeb&quot;\n"
		 * + "class=&quot;fullwidth&quot;&gt;\n" + "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;top&quot;&gt;&lt;table width=&quot;100%&quot; border=&quot;0&quot;\n"
		 * +
		 * "cellspacing=&quot;0&quot; cellpadding=&quot;0&quot; align=&quot;center&quot;\n"
		 * + "class=&quot;fullwidth90&quot;&gt;\n" + "\n" + "\n" + "\n" + "&lt;tr&gt;\n"
		 * + "&lt;td&gt;\n" +
		 * "&lt;table width=&quot;90%&quot; border=&quot;0&quot; cellspacing=&quot;0&quot; cellpadding=&quot;0&quot;\n"
		 * +
		 * "align=&quot;center&quot; class=&quot;fullwidth&quot; bgcolor=&quot;#ebebeb&quot;&gt;\n"
		 * + "\n" + "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;middle&quot;\n" +
		 * "style=&quot;font-family: Arial, sans-serif, &apos;Helvetica Neue&apos;, Helvetica; font-size: 14px; line-height: 20px; color: #1b1b1b;&quot;&gt;Hello\n"
		 * + "%(customername),&lt;br /&gt; Greetings from Airtel!\n" + "&lt;/td&gt;\n" +
		 * "&lt;/tr&gt;\n" + "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;middle&quot;\n" +
		 * "style=&quot;font-family: Arial, sans-serif, &apos;Helvetica Neue&apos;, Helvetica; font-size: 14px; line-height: 20px; color: #1b1b1b;&quot;&gt;&lt;br /&gt;\n"
		 * + "Click here for a Map: %(storelocationinmap)&lt;br /&gt;\n" +
		 * "&lt;br /&gt; We look forward to seeing you.&lt;br /&gt;&lt;/td&gt;\n" + "\n"
		 * + "&lt;/tr&gt;\n" + "&lt;tr&gt;\n" +
		 * "&lt;td height=&quot;30&quot; style=&quot;line-height: 0px; font-size: 0px&quot;&gt;&lt;/td&gt;\n"
		 * + "&lt;/tr&gt;\n" + "\n" + "&lt;tr&gt;\n" + "\n" +
		 * "&lt;td align=&quot;left&quot; valign=&quot;middle&quot;\n" +
		 * "style=&quot;font-family: Arial, sans-serif, &apos;Helvetica Neue&apos;, Helvetica; font-size: 14px; line-height: 18px; color: #1b1b1b;&quot;&gt;Warm\n"
		 * + "Regards,&lt;br /&gt; Team Airtel\n" + "&lt;/td&gt;\n" + "&lt;br /&gt;\n" +
		 * "&lt;br /&gt;\n" + "\n" + "&lt;tr&gt;\n" +
		 * "&lt;td height=&quot;10&quot; style=&quot;line-height: 0px; font-size: 0px&quot;&gt;&lt;/td&gt;\n"
		 * + "&lt;/tr&gt;\n" + "\n" + "&lt;/table&gt;\n" + "&lt;/td&gt;\n" +
		 * "&lt;/tr&gt;\n" + "\n" + "&lt;/table&gt;&lt;/td&gt;\n" + "&lt;/tr&gt;\n" +
		 * "\n" + "\n" + "\n" + "&lt;/table&gt;&lt;/td&gt;\n" + "&lt;/tr&gt;\n" +
		 * "&lt;tr&gt;\n" + "&lt;td height=&quot;5&quot;\n" +
		 * "style=&quot;line-height: 5px; font-size: 0; background-color: #ee1c25&quot;&gt;&lt;/td&gt;\n"
		 * + "&lt;/tr&gt;\n" + "&lt;/table&gt;\n" + "\n" + "&lt;/body&gt;\n" +
		 * "&lt;/html&gt; |\n" +
		 * "+-----+---------------------+----------------------+---------+--------+--------------------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+"
		 * ));
		// TODO Auto-generated method stub
		System.out.println(ZonedDateTime.now(ZoneId.systemDefault()));
		
		System.out.println(LocalDateTime.now());
		
		/*
		 * DTSTART:20200608T193500 DTEND:20200608T200500 LOCATION:localtion UID:test
		 * DTSTAMP:20200608T193500
		 */
	}

}
