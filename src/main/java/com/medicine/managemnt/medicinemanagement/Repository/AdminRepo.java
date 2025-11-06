package com.medicine.managemnt.medicinemanagement.Repository;

import com.medicine.managemnt.medicinemanagement.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long > {

    @Query(value = "select * from admin where email like ?1",nativeQuery = true)
    Admin getAdminbyemail(String email);
}
