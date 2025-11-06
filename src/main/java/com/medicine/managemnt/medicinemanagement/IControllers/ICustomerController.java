package com.medicine.managemnt.medicinemanagement.IControllers;

import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.dtos.Customerdto;
import org.springframework.web.bind.annotation.*;


public interface ICustomerController {

    @GetMapping("/getCustomer/{id}")
    Customer getCustomer(@PathVariable Long id);

    @PostMapping("/saveCustomer")
    Customer saveCustomer(@RequestBody Customerdto customerdto);

    @PutMapping("/upadateCustomer")
    Customer updateCustomer(@RequestBody Customerdto customerdto);

    @DeleteMapping("/deleteByCustomer/{id}")
    void deleteCustomer(@PathVariable Long id);
}
