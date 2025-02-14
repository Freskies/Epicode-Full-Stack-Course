package org.u5w2d5.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
	private final JavaMailSender mailSender;

	public void sendEmail(String to, String subject) throws MessagingException {
		sendEmail(to, subject, "Mail di spam");
	}

	public void sendEmail(String to, String subject, String body) throws MessagingException {
		if (body == null) body = "mail di default";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setFrom("your-email@gmail.com");

		mailSender.send(message);
		System.out.println("Email inviata con successo a " + to);
	}
}