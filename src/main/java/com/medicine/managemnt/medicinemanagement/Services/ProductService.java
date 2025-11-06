package com.medicine.managemnt.medicinemanagement.Services;

import com.medicine.managemnt.medicinemanagement.IServices.IProductService;
import com.medicine.managemnt.medicinemanagement.Model.Product;
import com.medicine.managemnt.medicinemanagement.Repository.ProductRepo;
import com.medicine.managemnt.medicinemanagement.dtos.Productdto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product getProductbyId(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getByCatagory(String catagory) {
        return productRepo.getByCatagory(catagory);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getByAdminEmail(String email) {
        return productRepo.getByAdminemail(email);
    }

    @Override
    public Product saveProduct(Productdto productdto) {
        return productRepo.save(getProductObject(productdto, new Product()));
    }

    @Override
    public Product updateProduct(Productdto productdto, Long id) {
        return productRepo.save(getProductObject(productdto, productRepo.findById(id).get()));
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    private Product getProductObject(Productdto productdto, Product product){
        product.setProductname(productdto.getProductname().isEmpty()?null: productdto.getProductname());
        product.setCatagory(productdto.getCatagory().isEmpty()?null: productdto.getCatagory());
        product.setAdmin_email(productdto.getAdmin_email().isEmpty()?null: productdto.getAdmin_email());
        product.setPrice(productdto.getPrice()==0?0: productdto.getPrice());
        product.setQuantity(productdto.getQuantity()==0?0: productdto.getQuantity());

        return product;
    }
}
