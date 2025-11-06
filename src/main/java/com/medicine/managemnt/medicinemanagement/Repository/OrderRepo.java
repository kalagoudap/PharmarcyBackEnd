package com.medicine.managemnt.medicinemanagement.Repository;

import com.medicine.managemnt.medicinemanagement.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
}
