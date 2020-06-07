import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
			//msg.se
			/*
			 * StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
			 * "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
			 * "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n" +
			 * "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:" + emailId + "\n" +
			 * "ORGANIZER:MAILTO:" + "drk6064@gmail.com" + "\n" +
			 * "DTSTART:20200607T113000Z\n" + "DTEND:20200607T120000Z\n" +
			 * "LOCATION:+TH-1\n" + "TRANSP:OPAQUE\n" + "SEQUENCE:0\n" +
			 * "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n"
			 * + " 000004377FE5C37984842BF9440448399EB02\n" + "DTSTAMP:20200607T103000Z\n" +
			 * "CATEGORIES:Session\n" + "DESCRIPTION:\n\n" +
			 * "SUMMARY:Session for tomorrow\n" + "PRIORITY:5\n" + "CLASS:PUBLIC\n" +
			 * "BEGIN:VALARM\n" + "TRIGGER:PT1440M\n" + "ACTION:DISPLAY\n" +
			 * "DESCRIPTION:Reminder\n" + "END:VALARM\n" + "END:VEVENT\n" +
			 * "END:VCALENDAR");
			 */

			StringBuffer buffer = messageText
					.append("BEGIN:VCALENDAR\n" + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
							+ "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n" + "ORGANIZER:MAILTO:");
			messageText.append("Ravikiran");
			messageText.append("\n" + "DTSTART:");
			messageText.append(LocalDateTime.now().toString());
			messageText.append("\n" + "DTEND:");
			messageText.append(LocalDateTime.now().plusMinutes(30).toString());
			messageText.append("\n" + "LOCATION:");
			messageText.append("localtion");
			messageText.append("\n" + "UID:");
			messageText.append("test");
			messageText.append("\n" + "DTSTAMP:");
			messageText.append(LocalDateTime.now().toString());
			/*
			 * messageText.append( "\n" +
			 * "DESCRIPTION;ALTREP=\"CID:<eventDescriptionHTML>\”" ) ;
			 */
			messageText.append("\n" + "BEGIN:VALARM\n" + "TRIGGER:-PT15M\n" + "ACTION:DISPLAY\n"
					+ "DESCRIPTION:Reminder\n" + "END:VALARM\n" + "END:VEVENT\n" + "END:VCALENDAR");

			// Create the message part
			BodyPart messageCalendar = new MimeBodyPart();

			// Fill the message
			messageCalendar.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
			messageCalendar.setHeader("Content-ID", "calendar_message");

			
			messageCalendar
					.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(), "text/calendar")));

			//MimeBodyPart bc = new MimeBodyPart();
			mailBody="<h1>Email Body</h1>"
					+ "<p>Hello Ravikiran</p>"
					+ "<p>Thank you for making your booking at the Airtel Store\r\n" + 
					"";
			messageCalendar.setContent(mailBody, "text/html");

			//BodyPart messageBody = bc;
			Multipart multipart = new MimeMultipart();

			// Add part one

			
			multipart.addBodyPart(messageCalendar);
			//multipart.addBodyPart(messageBody);

			// Put parts in message
			msg.setContent(multipart,"text/html");
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