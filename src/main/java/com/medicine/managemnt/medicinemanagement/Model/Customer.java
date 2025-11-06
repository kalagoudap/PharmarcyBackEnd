package com.medicine.managemnt.medicinemanagement.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phonenumber")
    private Long phonenumber;

    @Column(name = "Usertype")
    private String usertype;

    @Column(name = "Gender")
    private String gender;
}
