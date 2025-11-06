package com.medicine.managemnt.medicinemanagement.Services;


import com.medicine.managemnt.medicinemanagement.Constants.LoggedInDetails;
import com.medicine.managemnt.medicinemanagement.IServices.ICustomerService;
import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.Repository.CustomerRepo;
import com.medicine.managemnt.medicinemanagement.dtos.Customerdto;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    LoggedInDetails loggedInCustomerDetails;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customerdto customerdto) {
        Customer customer = new Customer();

        if(!customerdto.getName().isEmpty())
            customer.setName(customerdto.getName());
        if(!customerdto.getAddress().isEmpty())
            customer.setAddress(customerdto.getAddress());
        if(!customerdto.getEmail().isEmpty())
            customer.setEmail(customerdto.getEmail());
        if(customerdto.getPhonenumber() != 0)
            customer.setPhonenumber(customerdto.getPhonenumber());
        if (!customerdto.getGender().isEmpty())
            customer.setGender(customerdto.getGender());

        System.out.println("name"+customer.getName()+"phone"+customer.getPhonenumber());

        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customerdto customerdto) {
        Customer customer = customerRepo.findById(loggedInCustomerDetails.getCustomerId()).get();
         customer.setName(customerdto.getName().isEmpty()? customer.getName() : customerdto.getName());
         customer.setGender(customerdto.getGender().isEmpty()? customer.getGender() : customerdto.getGender());
         customer.setPhonenumber(customerdto.getPhonenumber() ==0 ? customer.getPhonenumber() : customerdto.getPhonenumber());
         customer.setEmail(customerdto.getEmail().isEmpty() ? customer.getEmail() : customerdto.getEmail());

        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}
