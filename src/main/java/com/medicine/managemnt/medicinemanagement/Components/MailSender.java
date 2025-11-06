package com.medicine.managemnt.medicinemanagement.Components;

import com.medicine.managemnt.medicinemanagement.Enums.SimpleMailenum;
import com.medicine.managemnt.medicinemanagement.IComponents.IMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender implements IMailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(SimpleMailenum simpleMailenum,String to,String name, int otp) {
        switch (simpleMailenum){

            case REGISTRATION : {
                String subject = "Medicine Project Registration";
                try{
                    javaMailSender.send(setMessage(to,subject,setBodyforRegistration(name)));
                    return true;
                }catch (MailSendException e){
                    e.getFailedMessages();
                }
                break;
            }
            case LOGINOTP: {
                String subject = "OTP Shared for Login";
                try{
                    javaMailSender.send(setMessage(to,subject,setBodyforLoginOTPbody(otp)));
                    return true;
                }catch (MailSendException e){
                    e.getFailedMessages();
                }
                break;
            }
            case ADMINSTATUS: {
                String subject = "Order Confirmation";
                try{
                    javaMailSender.send(setMessage(to,subject,setBodyforOrderConfirmation(name)));
                }catch (MailSendException e){
                    e.getFailedMessages();
                }
            }
            case ORDERCONFIRMATION: break;
            default: break;
        }
        return false;
    }

    private SimpleMailMessage setMessage(String to, String subject, String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        return simpleMailMessage;
    }

    private String setBodyforRegistration(String name){
        return "Hi "+name+",\n    Account have been created successfully.\n\n Best Regards, \n Medicine Project";
    }

    private String setBodyforLoginOTPbody(int otp){
        return "Hi,\n    Please consider your OTP "+otp+".\n\n Best Regards, \n Medicine Project";
    }

    private String setBodyforOrderConfirmation(String name){
        return "Hi "+name+",\n   Your Order with Pharmacy Application is Confirmed, Team will reach out with you shortly.\n Thanks for Choosing Us \n Best Regards,\n Kalagouda Patil ";
    }
}
