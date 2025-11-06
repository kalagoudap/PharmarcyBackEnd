package com.medicine.managemnt.medicinemanagement.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Cartdto {

    public Long productId;

    public String name;

    public Long customerId;

    public int quantity;

    public int price;
}
