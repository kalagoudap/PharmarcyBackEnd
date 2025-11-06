package com.medicine.managemnt.medicinemanagement.IControllers;

import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.dtos.Logindto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ILoginController {

    @PostMapping("/loginotp")
    boolean sendLoginOTP(@RequestBody Logindto logindto);

    @PostMapping("/customerLogin")
    Customer customerLogin(@RequestBody Logindto otp);

    @PostMapping("/adminLogin")
    Customer adminLogin(@RequestBody Logindto otp);

}
