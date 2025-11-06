package com.medicine.managemnt.medicinemanagement.IServices;

import com.medicine.managemnt.medicinemanagement.Model.Product;
import com.medicine.managemnt.medicinemanagement.dtos.Productdto;

import java.util.List;

public interface IProductService {

    Product getProductbyId(Long id);

    List<Product> getByCatagory(String catagory);

    List<Product> getAllProduct();

    List<Product> getByAdminEmail(String email);

    Product saveProduct(Productdto productdto);

    Product updateProduct(Productdto productdto, Long id);

    void deleteById(Long id);
}
