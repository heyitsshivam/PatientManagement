package com.example.astrotalk.controller;

import com.example.astrotalk.dto.CreatePatientDto;
import com.example.astrotalk.dto.PatientDto;
import com.example.astrotalk.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<PatientDto> addPatient(@RequestBody CreatePatientDto createPatientDto){
       return patientService.addPatient(createPatientDto);
    }

    @PutMapping("/discharge")
    public ResponseEntity<PatientDto> dischargePatient(@RequestParam String key){
        return patientService.dischargePatient(key);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PatientDto>> getAllPatient(@RequestParam(required = false, defaultValue = "admitDate") String sortBy,
                                                          @RequestParam(required = false, defaultValue = "0") int pageNo,
                                                          @RequestParam(required = true, defaultValue = "10") int pageSize,
                                                          @RequestParam(required = false, defaultValue = "asc") String sortOrder){
        return patientService.getAllPatient(sortBy, pageNo, pageSize, sortOrder);
    }
}
