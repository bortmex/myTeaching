package com.rog.teach.simpleSpring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailSender {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void send(String emailTo, String subject, String message) throws MessagingException {
        MimeMessage mailMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");

        String htmlMsg = message
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";

        mailMessage.setContent(htmlMsg, "text/html;charset=UTF-8");
        helper.setFrom(username);
        helper.setTo(emailTo);
        helper.setSubject(subject);
        helper.setText(message, "UTF-8");
        mailSender.send(mailMessage);
    }

}
