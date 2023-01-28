package com.krish.microservice.VaccinationCenter.Repository;

import com.krish.microservice.VaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
