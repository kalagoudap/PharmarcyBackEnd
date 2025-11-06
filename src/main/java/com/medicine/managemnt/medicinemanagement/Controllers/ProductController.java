package com.medicine.managemnt.medicinemanagement.Controllers;

import com.medicine.managemnt.medicinemanagement.IControllers.IProductController;
import com.medicine.managemnt.medicinemanagement.IServices.IProductService;
import com.medicine.managemnt.medicinemanagement.Model.Product;
import com.medicine.managemnt.medicinemanagement.dtos.Productdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ProductController implements IProductController {
    @Autowired
    IProductService productService;

    @Override
    public Product getProductbyId(Long id) {
        return productService.getProductbyId(id);
    }

    @Override
    public List<Product> getByCatagory(String catagory) {
        return productService.getByCatagory(catagory);
    }

    @Override
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @Override
    public List<Product> getByAdminEmail(String email) {
        return productService.getByAdminEmail(email);
    }

    @Override
    public Product saveProduct(Productdto productdto) {
        return productService.saveProduct(productdto);
    }

    @Override
    public Product updateProduct(Productdto productdto, Long id) {
        return productService.updateProduct(productdto,id);
    }

    @Override
    public void deleteById(Long id) {
         productService.deleteById(id);
    }
}
