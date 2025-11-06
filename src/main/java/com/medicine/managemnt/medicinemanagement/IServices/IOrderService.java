package com.medicine.managemnt.medicinemanagement.IServices;

import com.medicine.managemnt.medicinemanagement.Model.Orders;
import com.medicine.managemnt.medicinemanagement.dtos.Orderdto;

public interface IOrderService {
    Orders saveOrder(Orderdto orderdto);
}
