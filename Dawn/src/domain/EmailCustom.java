package domain;


import java.util.List;
import java.util.Properties;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCustom {
//	
//	private String address;
//	private final static  String USERNAME = "leuventestadres@gmail.com";
//	private final static  String PASSWORD = "Tvg258741";
//	
//	public EmailCustom(String address)
//	{
//		setAdress(address);
//	}
//
//	private void setAdress(String address) 
//	{
//		this.address = address;
//	}
//	
//	public String getAddress()
//	{
//		return this.address;
//	}
//	
//
//	public static void sendEmailTo( List<EmailCustom> emailList, String subject, String body)
//	{
//		String from = EmailCustom.USERNAME;
//	    Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");
//
//		Session session = Session.getDefaultInstance(props,
//			new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(USERNAME,PASSWORD);
//				}
//			});
//	    
//	    try{
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         for(EmailCustom e : emailList)
//	         {
//	        	 message.addRecipient(Message.RecipientType.TO, new InternetAddress(e.getAddress()));
//	         } 
//	         
//
//	         // Set Subject: header field
//	         message.setSubject(subject);
//
//	         // Now set the actual message
//	         message.setText(body);
//
//	         // Send message
//	         Transport.send(message);
//	         System.out.println("Sent message successfully....");
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
		
	//}
}
