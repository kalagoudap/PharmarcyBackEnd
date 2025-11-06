package com.medicine.managemnt.medicinemanagement.Configurations;

import com.medicine.managemnt.medicinemanagement.Components.MailSender;
import com.medicine.managemnt.medicinemanagement.IComponents.IMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailsendingConfiguration {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("kalagoudapatil508@gmail.com");
        mailSender.setPassword("seio izvw jwbw irpl");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public IMailSender getIMailSender(){
        return new MailSender();
    }

}
