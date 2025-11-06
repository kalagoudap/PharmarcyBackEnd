package com.medicine.managemnt.medicinemanagement.Services;

import com.medicine.managemnt.medicinemanagement.IServices.ILoginService;
import com.medicine.managemnt.medicinemanagement.Model.Admin;
import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.Repository.AdminRepo;
import com.medicine.managemnt.medicinemanagement.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService implements ILoginService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AdminRepo adminRepo;

    @Override
    public Customer loginotpcheck(String email) {
        return customerRepo.findbyEmail(email);
    }

    @Override
    public Admin getAdminbyemail(String email) {
        return adminRepo.getAdminbyemail(email);
    }


}
