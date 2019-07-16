package com.sims.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public interface MailHelper {
		public static  boolean sendOTP(String recipientEmail,String OTP) {
			 final String username = "pranshulsingla@gmail.com";
		     final String password = "Anjali123@";

		        Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
		        prop.put("mail.smtp.port", "587");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		        
		        
		        // Step - 1 Authenticate
		        Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(username, password);
		                    }
		                });

		        // Step-2 From , to , Subject, Content
		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("pranshulsingla@gmail.com"));
		            message.setRecipients(
		                    Message.RecipientType.TO,
		                    InternetAddress.parse(recipientEmail)
		            );
		            message.setSubject("One Time Password for password reset");
		            message.setText("Your OTP is "+OTP);
		            
		            // Step-3 Send the Message
		            Transport.send(message);

		            System.out.println("OTP sent");
		            return true;

		        } catch (MessagingException e) {
		            e.printStackTrace();
		            return false;
		        }

		}

}
