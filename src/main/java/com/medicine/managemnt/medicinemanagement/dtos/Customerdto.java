package com.medicine.managemnt.medicinemanagement.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customerdto {

    public String name;

    public String email;

    public String address;

    public Long phonenumber;

    public String gender;

}
