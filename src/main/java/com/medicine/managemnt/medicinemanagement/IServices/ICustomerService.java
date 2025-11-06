package com.medicine.managemnt.medicinemanagement.IServices;

import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.dtos.Customerdto;


public interface ICustomerService {

    Customer getCustomer(Long id);

    Customer saveCustomer(Customerdto customerdto);

    Customer updateCustomer(Customerdto customerdto);

    void deleteCustomer(Long id);
}
