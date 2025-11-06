package com.medicine.managemnt.medicinemanagement.Controllers;


import com.medicine.managemnt.medicinemanagement.Constants.LoggedInDetails;
import com.medicine.managemnt.medicinemanagement.Enums.SimpleMailenum;
import com.medicine.managemnt.medicinemanagement.IComponents.IMailSender;
import com.medicine.managemnt.medicinemanagement.IControllers.ILoginController;
import com.medicine.managemnt.medicinemanagement.IServices.ILoginService;
import com.medicine.managemnt.medicinemanagement.Model.Admin;
import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.dtos.Logindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController implements ILoginController {
    @Autowired
    IMailSender mailSender;

    @Autowired
    ILoginService loginService;

    @Autowired
    LoggedInDetails loggedInDetails;

    private String mailAddress = null;
    private int otp = 0;
    Customer customer = null;
    Admin admin = null;

    @Override
    public boolean sendLoginOTP(Logindto logindto) {
        Random random = new Random();
        otp = random.nextInt(1000,9999);
        mailAddress = logindto.getTo();
        System.out.println("OTP Sending Mail Address"+mailAddress+" and "+ logindto.getUserType());
        if (logindto.getUserType().equals("User")){
            customer =  loginService.loginotpcheck(mailAddress);
            System.out.println("Email from Customer Entity"+customer.getEmail());
            return mailSender.sendMail(SimpleMailenum.LOGINOTP,logindto.getTo(),null,otp);
        }else{
            admin = loginService.getAdminbyemail(mailAddress);
            System.out.println("Email from Customer Entity"+admin.getEmail());
            return mailSender.sendMail(SimpleMailenum.LOGINOTP,logindto.getTo(),null,otp);
        }
    }

    @Override
    public Customer customerLogin(Logindto logindto){
        if (logindto != null  && otp == logindto.getOtp()){
            loggedInDetails.setCustomerId(customer.getId());
            loggedInDetails.setEmail(customer.getEmail());
            return customer;
        }else{
            return null;
        }
    }

    @Override
    public Customer adminLogin(Logindto logindto) {
        if (logindto != null  && otp == logindto.getOtp()){
            loggedInDetails.setCustomerId(admin.getId());
            loggedInDetails.setEmail(admin.getEmail());
            return customer;
        }else{
            return null;

        }
    }


}
