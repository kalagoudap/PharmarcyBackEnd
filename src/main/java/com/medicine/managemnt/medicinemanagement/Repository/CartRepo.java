package com.medicine.managemnt.medicinemanagement.Repository;

import com.medicine.managemnt.medicinemanagement.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    @Query(value = "select * from cart where customer_id = ?1",nativeQuery = true)
    public List<Cart> getByCustomerId(Long customerId);
}
