package com.krish.microservice.citizenservice.repository;

import com.krish.microservice.citizenservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICitizenRepo extends JpaRepository<Citizen, Integer> {
    List<Citizen> findByVaccinationCenterId(int id);
}
