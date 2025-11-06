package com.medicine.managemnt.medicinemanagement.Repository;

import com.medicine.managemnt.medicinemanagement.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where catagory like ?1",nativeQuery = true)
    List<Product> getByCatagory(String catagory);

    @Query(value = "select * from product where adminemail like ?1",nativeQuery = true)
    List<Product> getByAdminemail(String adminemail);


}
