package com.medicine.managemnt.medicinemanagement.Controllers;

import com.medicine.managemnt.medicinemanagement.IControllers.ICartController;
import com.medicine.managemnt.medicinemanagement.IServices.ICartService;
import com.medicine.managemnt.medicinemanagement.Model.Cart;
import com.medicine.managemnt.medicinemanagement.dtos.Cartdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CartController implements ICartController {

    @Autowired
    public ICartService cartService;

    public Cart saveCart(Cartdto cartdto){
        return cartService.additemtoCart(cartdto);
    }

    public List<Cart> getByCustomerId(Long id){
        return cartService.getByCustomerID(id);
    }

    public Optional<Cart> getByCartId(Long id){
        return cartService.getByCartId(id);
    }
}
