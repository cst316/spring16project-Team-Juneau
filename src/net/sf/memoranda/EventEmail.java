package net.sf.memoranda;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EventEmail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	private String emailAddress;
	private String messageBody;
	
	
	public EventEmail(String email, String eventText){
		emailAddress = email;
		messageBody = eventText;
	}
	
	public boolean sendNewEmail(){
	
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		try{
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
		generateMailMessage.setSubject("Memoranda Event Notification");
		String emailBody = messageBody;
		generateMailMessage.setContent(emailBody, "text/html");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "cst316teamjuneau", "1234QWER");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		}catch (SendFailedException e) {
			System.out.println("Invalid Email Address: " + emailAddress);
			return false;
		}catch (MessagingException e) {
			return false;
		} 
		return true;
	}
}
