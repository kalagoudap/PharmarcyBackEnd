package com.medicine.managemnt.medicinemanagement.IServices;

import com.medicine.managemnt.medicinemanagement.Model.Admin;
import com.medicine.managemnt.medicinemanagement.Model.Customer;

public interface ILoginService {
    Customer loginotpcheck(String email);

    Admin getAdminbyemail(String email);
}
