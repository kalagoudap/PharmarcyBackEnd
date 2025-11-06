package com.medicine.managemnt.medicinemanagement.Repository;

import com.medicine.managemnt.medicinemanagement.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer where email LIKE ?1", nativeQuery = true)
    Customer findbyEmail(String email);
}
