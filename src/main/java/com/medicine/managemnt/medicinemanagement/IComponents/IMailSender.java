package com.medicine.managemnt.medicinemanagement.IComponents;

import com.medicine.managemnt.medicinemanagement.Enums.SimpleMailenum;

public interface IMailSender {
    boolean sendMail(SimpleMailenum simpleMailenum,String to,String name, int otp);
}
