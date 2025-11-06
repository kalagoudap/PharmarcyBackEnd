package com.medicine.managemnt.medicinemanagement.Controllers;

import com.medicine.managemnt.medicinemanagement.IControllers.IOrderController;
import com.medicine.managemnt.medicinemanagement.IServices.IOrderService;
import com.medicine.managemnt.medicinemanagement.Model.Orders;
import com.medicine.managemnt.medicinemanagement.dtos.Orderdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000/")
@RestController
public class OrderController implements IOrderController {
    @Autowired
    IOrderService orderService;

    @Override
    public Orders saveOrder(Orderdto orderdto) {
        return orderService.saveOrder(orderdto);
    }
}
