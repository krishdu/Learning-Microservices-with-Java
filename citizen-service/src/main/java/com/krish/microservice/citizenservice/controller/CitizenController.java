package com.krish.microservice.citizenservice.controller;

import com.krish.microservice.citizenservice.entity.Citizen;
import com.krish.microservice.citizenservice.repository.ICitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    private ICitizenRepo _citizenRepo;

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Server is running fine", HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getCitizenByVaccinationCenterId(@PathVariable int id) {
        List<Citizen>  lstCitizen = _citizenRepo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(lstCitizen, HttpStatus.OK);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        Citizen newCitizen = _citizenRepo.save(citizen);
        return new ResponseEntity<>(newCitizen, HttpStatus.CREATED);
    }
}
