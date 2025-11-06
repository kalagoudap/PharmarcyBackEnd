package com.medicine.managemnt.medicinemanagement.dtos;

import com.medicine.managemnt.medicinemanagement.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Orderdto {

    public  Long customerId;

    public List<Integer> productsIds;

    public Long totalprice;

    public Integer quantity;
}
