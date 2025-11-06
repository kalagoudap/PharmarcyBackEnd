package com.medicine.managemnt.medicinemanagement.IServices;

import com.medicine.managemnt.medicinemanagement.Model.Cart;
import com.medicine.managemnt.medicinemanagement.dtos.Cartdto;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    Cart additemtoCart(Cartdto cartdto);

    List<Cart> getByCustomerID(Long id);

    Optional<Cart> getByCartId(Long id);
}
