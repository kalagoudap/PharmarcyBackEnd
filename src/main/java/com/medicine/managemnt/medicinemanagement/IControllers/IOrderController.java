package com.medicine.managemnt.medicinemanagement.IControllers;

import com.medicine.managemnt.medicinemanagement.Model.Orders;
import com.medicine.managemnt.medicinemanagement.dtos.Orderdto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IOrderController {
    @PostMapping("/orderCartItem")
    Orders saveOrder(@RequestBody Orderdto orderdto);
}
