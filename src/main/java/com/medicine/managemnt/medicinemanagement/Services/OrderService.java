package com.medicine.managemnt.medicinemanagement.Services;

import com.medicine.managemnt.medicinemanagement.Components.MailSender;
import com.medicine.managemnt.medicinemanagement.Enums.SimpleMailenum;
import com.medicine.managemnt.medicinemanagement.IServices.IOrderService;
import com.medicine.managemnt.medicinemanagement.Model.Customer;
import com.medicine.managemnt.medicinemanagement.Model.Orders;
import com.medicine.managemnt.medicinemanagement.Repository.CustomerRepo;
import com.medicine.managemnt.medicinemanagement.Repository.OrderRepo;
import com.medicine.managemnt.medicinemanagement.dtos.Orderdto;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService implements IOrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    MailSender mailSender;

    @Override
    public Orders saveOrder(Orderdto orderdto) {
        Orders order = new Orders();

        order.setCustomerId(orderdto.getCustomerId() != 0 ? orderdto.getCustomerId() : 0);
        order.setProductIDs(orderdto.getProductsIds().isEmpty() ? null : orderdto.getProductsIds());
        order.setQunatity(orderdto.getQuantity()!=0 ? orderdto.getQuantity() : 0);
        order.setTotalPrice(orderdto.getTotalprice() != 0 ? orderdto.getTotalprice() : 0);
        Customer customer = customerRepo.findById(orderdto.getCustomerId()).get();
        mailSender.sendMail(SimpleMailenum.ORDERCONFIRMATION, customer.getEmail(), customer.getName(),0);
        return orderRepo.save(order);
    }
}
