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
import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.Priority;
import net.fortuna.ical4j.model.property.Version;

public class GoogleCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GoogleCalender().sendEmail("test@gmail.com", "drk6064@gmail.com", "sub", "text", new GoogleCalender().getInvite());

	}
	
	private Calendar getInvite() {
	    Calendar calendar = new Calendar();
	    calendar.getProperties().add(Version.VERSION_2_0);
	   // calendar.getProperties().add(0, "");

	    VEvent event = new VEvent(
	        new DateTime(new Date()), 
	        new DateTime(new Date()), 
	        "");

	    event.getProperties().add(Priority.MEDIUM);
	    event.getProperties().add(Clazz.PUBLIC);
	    
		/*
		 * UidGenerator ug = null;
		 * 
		 * ug = new UidGenerator() {
		 * 
		 * @Override public Uid generateUid() { Uid uid = ug.generateUid();
		 * event.getProperties().add(uid); return uid; } };
		 */

		/*
		 * for (Participant participant : session.getParticipants()) { Attendee attendee
		 * = new Attendee(URI.create("mailto:" + participant.getEmail()));
		 * attendee.getParameters().add(Role.OPT_PARTICIPANT);
		 * attendee.getParameters().add(new Cn(participant.getName()));
		 * attendee.getParameters().add(PartStat.NEEDS_ACTION);
		 * event.getProperties().add(attendee); }
		 */

	    calendar.getComponents().add(event);

	    return calendar;

	}
	
	public void sendEmail(String fromMail, String toMail, String subject, String text, net.fortuna.ical4j.model.Calendar calendar) {
	    try {
	        Session session = Session.getInstance(getMailProperties(), new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("","");
	            }
	        });

	        MimeMessage mimeMessage = new MimeMessage(session);
	        mimeMessage.setHeader("Content-Transfer-Encoding:", "7bit");

	        Address address = new InternetAddress(fromMail);
	        mimeMessage.setFrom(address);

	        mimeMessage.setSentDate(java.util.Calendar.getInstance().getTime());
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

	    } catch (Exception e) {
	        // Log things
	    }

	}

	private Properties getMailProperties() {
		 //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host","mail.smtp.com");  
		   props.put("mail.smtp.auth", "true");  
		   return props;
	}

}
