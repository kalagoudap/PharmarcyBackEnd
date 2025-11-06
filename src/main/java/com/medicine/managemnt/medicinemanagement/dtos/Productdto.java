package com.medicine.managemnt.medicinemanagement.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Productdto {

    public String productname;

    public Long price;

    public Integer quantity;

    public String catagory;

    public String admin_email;
}
