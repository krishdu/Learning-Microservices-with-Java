package com.krish.microservice.VaccinationCenter.Controller;

import com.krish.microservice.VaccinationCenter.Entity.VaccinationCenter;
import com.krish.microservice.VaccinationCenter.Model.Citizen;
import com.krish.microservice.VaccinationCenter.Model.VaccinationCenterData;
import com.krish.microservice.VaccinationCenter.Repository.ICenterRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private ICenterRepo _centerRepo;

    private static final String SERVICE_NAME = "VaccinationCenterService";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter center) {
        VaccinationCenter newCenter = _centerRepo.save(center);
        return new ResponseEntity<>(newCenter, HttpStatus.CREATED);
    }

    @RequestMapping(path="/id/{id}")
    @CircuitBreaker(
            name = SERVICE_NAME,
            fallbackMethod = "handleCitizenDowntime"
    )
    public ResponseEntity<VaccinationCenterData> getAllDataByCenterId(@PathVariable int id) {
        VaccinationCenterData  vaccinationCenterData = new VaccinationCenterData();
        VaccinationCenter vaccinationCenter = _centerRepo.findById(id).get();

        vaccinationCenterData.setCenter(vaccinationCenter);
        //get from other service
        //List<Citizen> listOfCitizen =  restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);

        //get using Eureka
        List<Citizen> listOfCitizen =  restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);

        vaccinationCenterData.setCitizens(listOfCitizen);

        return new ResponseEntity<>(vaccinationCenterData, HttpStatus.OK);
    }

    public ResponseEntity<VaccinationCenterData> handleCitizenDowntime(int id, Exception e) {
        VaccinationCenterData  vaccinationCenterData = new VaccinationCenterData();
        VaccinationCenter vaccinationCenter = _centerRepo.findById(id).get();
        vaccinationCenterData.setCenter(vaccinationCenter);

        return new ResponseEntity<>(vaccinationCenterData, HttpStatus.OK);
    }

}
