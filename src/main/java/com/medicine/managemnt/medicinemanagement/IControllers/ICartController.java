package com.medicine.managemnt.medicinemanagement.IControllers;

import com.medicine.managemnt.medicinemanagement.Model.Cart;
import com.medicine.managemnt.medicinemanagement.dtos.Cartdto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface ICartController {

    @PostMapping("/savecart")
    Cart saveCart(@RequestBody Cartdto cartdto);

    @GetMapping("/getbyCustmerId/{id}")
    List<Cart> getByCustomerId(@PathVariable Long id);

    @GetMapping("/getbycartid/{id}")
    Optional<Cart> getByCartId(@PathVariable Long id);


}
