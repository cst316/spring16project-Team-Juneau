package net.sf.memoranda;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EventEmail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	private static String emailAddress;
	private static String messageBody;
	
	
	public EventEmail(String email, String eventText){
		emailAddress = email;
		messageBody = eventText;
	}
	
	public static void sendNewEmail() throws AddressException, MessagingException{
	
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
		generateMailMessage.setSubject("Memoranda Event Notification");
		String emailBody = messageBody;
		generateMailMessage.setContent(emailBody, "text/html");
		
		Transport transport = getMailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "cst316teamjuneau", "1234QWER");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		
	}
}
