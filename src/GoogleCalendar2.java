import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
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

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.CompatibilityHints;

public class GoogleCalendar2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Session session = Session.getInstance(new GoogleCalendar2().getMailProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("drk6064@gmail.com","rAMUDU@123");
            }
        });
		
		MimeMessage mimeMessage = new GoogleCalendar2().createMimeMessage(session);
		Transport.send(mimeMessage);
	}

	public MimeMessage createMimeMessage(Session session) throws Exception {
		MimeMessage mimeMessage = new MimeMessage(session);
		mimeMessage.setSubject("Test Subject");
		mimeMessage.addFrom(new InternetAddress[]{new InternetAddress("drk6064@gmail.com")});
		mimeMessage.addRecipients(Message.RecipientType.TO, "drk6064@gmail.com");
		// The following two steps of processing is very important, you can avoid
		// Outlook to generate generated calendar items as attachments
		Multipart multipart = new MimeMultipart();
		MimeBodyPart iCalAttachment = new MimeBodyPart();
		byte[] invite = createICalInvitation("12345", "Test Subject", "testcontent", new Date(), new Date()
				);
		// The handling of
		/*
		 * setDataHandler is also very critical If you follow the process directly
		 * mimeMessage.setContent(iCalAttachment , "text/calendar"); Then the following
		 * exception will be thrown when the mail is sent.
		 * javax.activation.UnsupportedDataTypeException: no object DCH for MIME type
		 * text/calendar If the transmission is successful, no solution is found at
		 * present.
		 */
		iCalAttachment.setDataHandler(new DataHandler(new ByteArrayDataSource(new ByteArrayInputStream(invite),
				"text/calendar;method=REQUEST;charset=\"UTF-8\"")));
		multipart.addBodyPart(iCalAttachment);
		mimeMessage.setContent(multipart);
		return mimeMessage;
	}

	private byte[] createICalInvitation(String _meetingID, String _subject, String _content, Date _start, Date _end
			) throws Exception {
		CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_OUTLOOK_COMPATIBILITY, true);
		CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_NOTES_COMPATIBILITY, true);

		VEvent vEvent = new VEvent();
		vEvent.getProperties().add(new Uid(_meetingID));
		vEvent.getProperties().add(new Summary(_subject));
		vEvent.getProperties().add(new Description(_content));
		vEvent.getProperties().add(new DtStart(new DateTime(_start)));
		vEvent.getProperties().add(new DtEnd(new DateTime(_end)));
		vEvent.getProperties().add(new Attendee());
		vEvent.getProperties().add(new Organizer());

		Calendar cal = new Calendar();
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
		cal.getProperties().add(Version.VERSION_2_0);
		cal.getProperties().add(CalScale.GREGORIAN);
		cal.getProperties().add(Method.REQUEST);
		//TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		//VTimeZone tz = registry.getTimeZone(_tz.getID()).getVTimeZone();
		//cal.getComponents().add(tz);
		cal.getComponents().add(vEvent);

		// If the mail content of the calendar is garbled, you can consider generating
		// the stream by converting the calendar content into bytes according to some
		// encoding.
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		CalendarOutputter outputter = new CalendarOutputter();
		outputter.output(cal, bout);
		return bout.toByteArray();
	}

	private Properties getMailProperties() {
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.smtp.com");
		props.put("mail.smtp.auth", "true");
		return props;
	}

}
