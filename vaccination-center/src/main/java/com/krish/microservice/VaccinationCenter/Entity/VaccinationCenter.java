package com.krish.microservice.VaccinationCenter.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String centerName;
    private String centerAddress;

}
