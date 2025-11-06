package com.medicine.managemnt.medicinemanagement.IControllers;

import com.medicine.managemnt.medicinemanagement.Model.Product;
import com.medicine.managemnt.medicinemanagement.dtos.Productdto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @GetMapping("/getbyproductid/{id}")
    Product getProductbyId(@PathVariable Long id);

    @GetMapping("/getByproductCatagory/{catagory}")
    List<Product> getByCatagory(@PathVariable String catagory);

    @GetMapping("/getALlProduct")
    List<Product> getAllProduct();

    @GetMapping("getByAdminmail")
    List<Product> getByAdminEmail(String email);

    @PostMapping("/saveProduct")
    Product saveProduct(@RequestBody Productdto productdto);

    @PostMapping("/upadateProduct/{id}")
    Product updateProduct(@RequestBody Productdto productdto, @PathVariable Long id);

    @DeleteMapping("/deletebyproductId/{id}")
    void deleteById(@PathVariable Long id);
}
