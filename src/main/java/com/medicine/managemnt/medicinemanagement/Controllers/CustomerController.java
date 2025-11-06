package com.medicine.managemnt.medicinemanagement.Controllers;


import com.medicine.managemnt.medicinemanagement.Enums.SimpleMailenum;
import com.medicine.managemnt.medicinemanagement.IComponents.IMailSender;
import com.medicine.managemnt.medicinemanagement.IControllers.ICustomerController;
import com.medicine.managemnt.medicinemanagement.IServices.ICustomerService;
import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.dtos.Customerdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CustomerController implements ICustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IMailSender mailSender;

    @Override
    public Customer getCustomer(Long id) {
        return iCustomerService.getCustomer(id);
    }

    @Override
    public Customer saveCustomer(Customerdto customerdto) {
        System.out.println("Address"+customerdto.getAddress()+"Name"+customerdto.getName());
        mailSender.sendMail(SimpleMailenum.REGISTRATION, customerdto.getEmail(), customerdto.getName(), 0);
        return iCustomerService.saveCustomer(customerdto);
    }

    @Override
    public Customer updateCustomer(Customerdto customerdto) {
        return iCustomerService.updateCustomer(customerdto);
    }

    @Override
    public void deleteCustomer(Long id) {
         iCustomerService.deleteCustomer(id);
    }
}
