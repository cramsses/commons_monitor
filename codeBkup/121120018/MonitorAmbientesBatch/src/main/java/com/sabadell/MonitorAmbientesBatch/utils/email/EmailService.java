package com.sabadell.MonitorAmbientesBatch.utils.email;

import javax.mail.internet.MimeMessage;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailService {
	
	private static final Logger LOGGER = Logger.getLogger(EmailService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void send() {
		sendPlainTextMailTest();
	}
	
	public void send(EmailDTO eParams) {
		if (eParams.isHtml()) {
			try {
				sendHtmlMail(eParams);
				LOGGER.info("Enviado");
			} catch (MessagingException e) {
				LOGGER.error("Could not send email to :"+eParams.getToAsList()+" Error = "+e.getMessage());
			}
		} else {
			sendPlainTextMail(eParams);
		}
	}
	
	private void sendPlainTextMailTest() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo("sessmar@hotmail.com");
		mailMessage.setReplyTo("abc@hotmail.com");
		mailMessage.setFrom("cramsses@gmail.com");
		mailMessage.setSubject("Hardcode Test Spring Boot");
		mailMessage.setText("Prueba hardcodeada de mail sede java");
		
		mailSender.send(mailMessage);
	}
	
	private void sendHtmlMail(EmailDTO eParams) throws MessagingException {
		boolean isHtml = true;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
		helper.setReplyTo(eParams.getFrom());
		helper.setFrom(eParams.getFrom());
		helper.setSubject(eParams.getSubject());
		helper.setText(eParams.getMessage(), isHtml);
		if (eParams.getCc().size() > 0) {
			helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}
		mailSender.send(message);
	}
	
	private void sendPlainTextMail(EmailDTO eParams) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		eParams.getTo().toArray(new String[eParams.getTo().size()]);
		mailMessage.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
		mailMessage.setReplyTo(eParams.getFrom());
		mailMessage.setFrom(eParams.getFrom());
		mailMessage.setSubject(eParams.getSubject());
		mailMessage.setText(eParams.getMessage());
		if (eParams.getCc().size() > 0) {
			mailMessage.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}
		mailSender.send(mailMessage);
	}

}
