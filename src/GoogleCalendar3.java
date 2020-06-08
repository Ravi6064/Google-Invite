import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class GoogleCalendar3 {

	public static void main(String[] args) {
		 sendMail("drk6064@gmail.com", "Calendar Subject", "This is the Body of the email");
		//sendMail("ravikiran.daggupati@airtel.com", "Calendar Subject", "This is the Body of the email");
	}

	public static void sendMail(String emailId, String subject, String mailBody)

	{
		// PropertyWriter pw=new PropertyWriter();

		/*
		 * try { // pw.instantiateReadObjects(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		try {
			String smtpHost = "smtp.gmail.com";
			String smtpPort = "587";
			final String fromAddress = "drk6064@gmail.com";
			final String password = "rAMUDU@123";

			String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

			/*
			 * Properties props = new Properties();
			 * 
			 * props.put("mail.smtp.host", smtpHost); props.put("mail.smtp.auth", "true");
			 * props.put("mail.debug", "true"); props.put("mail.smtp.port", smtpPort);
			 * props.put("mail.smtp.socketFactory.port", smtpPort);
			 * props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			 * props.put("mail.smtp.starttls.enable", "ture");
			 * props.put("mail.smtp.socketFactory.fallback", "false");
			 */
			Session session = Session.getDefaultInstance(new GoogleCalendar3().getMailProperties(),
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("drk6064@gmail.com", "rAMUDU@123");
						}
					});

			session.setDebug(true);
			Message msg = new MimeMessage(session);

			InternetAddress addressFrom = new InternetAddress(fromAddress);
			msg.setFrom(addressFrom);

			InternetAddress addressTo = new InternetAddress(emailId);
			msg.setRecipient(Message.RecipientType.TO, addressTo);

			msg.setSubject(subject);

			StringBuffer messageText = new StringBuffer();
			System.out.println(mailBody);
			// msg.se

			/*
			 * StringBuffer buffer = messageText.append( "BEGIN:VCALENDAR\n" +
			 * "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
			 * "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n" +
			 * "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:" + emailId + "\n" +
			 * "ORGANIZER:MAILTO:" + "drk6064@gmail.com" + "\n"); messageText.append("\n" +
			 * "DTSTART:");
			 * messageText.append(LocalDateTime.now().plusMinutes(120).toString());
			 * messageText.append("\n" + "DTEND:");
			 * messageText.append(LocalDateTime.now().plusMinutes(150).toString());
			 * messageText.append("\n"); messageText.append("LOCATION:location" +
			 * "\nUID:test" + "\nDTSTAMP:20200607T103000Z" +LocalDateTime.now().toString()+
			 * "\nDESCRIPTION:\n" + "BEGIN:VALARM\n" + "TRIGGER:-PT15M\n" +
			 * "ACTION:DISPLAY\n" + "DESCRIPTION:Reminder\n" + "END:VALARM\n" +
			 * "END:VEVENT\n" + "END:VCALENDAR");
			 */

			//System.out.println("Buffer is " + buffer);

			
			  StringBuffer buffer = messageText .append("BEGIN:VCALENDAR\n" +
			  "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
			  "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n"
			  +"ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:" + emailId +
			  "\n"+"ORGANIZER:MAILTO:"+"drk6064@gmail.com"+"\n"); messageText.append("\n" +
			  "DTSTART:");
			  messageText.append(LocalDateTime.now(ZoneId.of("Asia/Kolkata")).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm'00'")));
			  messageText.append("\n" + "DTEND:");
			  messageText.append(LocalDateTime.now(ZoneId.of("Asia/Kolkata")).plusMinutes(30).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm'00'")));
			  messageText.append("\n" + "LOCATION:localtion"); messageText.append("\n" +
			  "UID:test"); 
			  messageText.append("\n"+"DTSTAMP:"+LocalDateTime.now(ZoneId.of("Asia/Kolkata")).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm'00'")));
			  //messageText.append(LocalDateTime.now().toString()); 
			  messageText.append("\n" +
			  "BEGIN:VALARM\n" + "TRIGGER:-PT15M\n" + "ACTION:DISPLAY\n" +
			  "DESCRIPTION:Reminder\n" + "END:VALARM\n" + "END:VEVENT\n" +
			  "END:VCALENDAR");
			 

			// Create the message part
			BodyPart messageCalendar = new MimeBodyPart();

			// Fill the message
			messageCalendar.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
			messageCalendar.setHeader("Content-ID", "calendar_message");

			messageCalendar
					.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(), "text/calendar")));

			MimeBodyPart bc = new MimeBodyPart();
			mailBody = "<h1>Email Body</h1>" + "<p>Hello Ravikiran</p>"
					+ "<p>Thank you for making your booking at the Airtel Store\r\n" + "";
			bc.setContent(mailBody, "text/html");

			BodyPart messageBody = bc;
			Multipart multipart = new MimeMultipart();

			// Add part one

			multipart.addBodyPart(messageCalendar);
			multipart.addBodyPart(messageBody);

			// Put parts in message
			msg.setContent(multipart, "text/html");
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Properties getMailProperties() {
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.debug", "true");
		return props;
	}

}