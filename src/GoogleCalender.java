import java.net.SocketException;
import java.net.URI;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.Priority;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.CompatibilityHints;
import net.fortuna.ical4j.util.FixedUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

public class GoogleCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = Session.getDefaultInstance(new GoogleCalender().getMailProperties(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("drk6064@gmail.com", "rAMUDU@123");
					}
				});

		new GoogleCalender().sendEmail("drk6064@gmail.com", "ravikiran.daggupati@airtel.com", "sub", "text",
				new GoogleCalender().getInvite(session), session);

	}

	private Calendar getInvite(Session session) {
		CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_OUTLOOK_COMPATIBILITY, true);
		CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_NOTES_COMPATIBILITY, true);

		Calendar calendar = new Calendar();
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(Method.REQUEST);

		VEvent event = new VEvent(new DateTime(new Date()), new DateTime(new Date().getTime()+1000000000), "Test");

		event.getProperties().add(Priority.MEDIUM);
		event.getProperties().add(Clazz.PUBLIC);

		try {
			UidGenerator ug = new FixedUidGenerator("uidGen");
			Uid uid = ug.generateUid();
			event.getProperties().add(uid);
		} catch (SocketException e) { // Log things }
		}
		
		Attendee attendee = new Attendee(URI.create("mailto:" + "drk6064@gmail.com"));
		attendee.getParameters().add(Role.OPT_PARTICIPANT);
		attendee.getParameters().add(new Cn("Ravikiran"));
		attendee.getParameters().add(PartStat.NEEDS_ACTION);
		event.getProperties().add(attendee);

		calendar.getComponents().add(event);

		return calendar;

	}

	public void sendEmail(String fromMail, String toMail, String subject, String text,
			net.fortuna.ical4j.model.Calendar calendar, Session session) {
		try {
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setHeader("Content-Transfer-Encoding:", "7bit");

			Address address = new InternetAddress(fromMail);
			mimeMessage.setFrom(address);

			mimeMessage.setSentDate(new Date());
			mimeMessage.setRecipients(Message.RecipientType.TO, toMail);

			mimeMessage.setSubject(subject);
			java.util.Calendar cal = java.util.Calendar.getInstance();
			mimeMessage.setSentDate(cal.getTime());

			Multipart multipart = new MimeMultipart("alternative");

			// First part - HTML readable text
			MimeBodyPart msgHtml = new MimeBodyPart();
			msgHtml.setContent(text, "text/html; charset=UTF-8");

			multipart.addBodyPart(msgHtml);

			if (calendar != null) {
				// Another part for the calendar invite
				MimeBodyPart invite = new MimeBodyPart();
				invite.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
				invite.setHeader("Content-ID", "calendar_message");
				invite.setHeader("Content-Disposition", "inline");
				invite.setContent(calendar.toString(), "text/calendar");
				multipart.addBodyPart(invite);
			}

			mimeMessage.setContent(multipart);

			Transport.send(mimeMessage);
			System.out.println("Emaial Sent");

		} catch (Exception e) {
			// Log things
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
