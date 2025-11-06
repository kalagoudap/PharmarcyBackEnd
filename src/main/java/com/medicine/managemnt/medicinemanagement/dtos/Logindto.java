package com.medicine.managemnt.medicinemanagement.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Logindto {

    public int otp;

    public String to;

    public String userType;

}
