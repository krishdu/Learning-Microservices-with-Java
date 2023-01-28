package com.krish.microservice.VaccinationCenter.Model;

import com.krish.microservice.VaccinationCenter.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenterData {
    private VaccinationCenter center;
    private List<Citizen> citizens;
}
