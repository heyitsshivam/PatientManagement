package com.example.astrotalk.service;

import com.example.astrotalk.dto.CreatePatientDto;
import com.example.astrotalk.dto.PatientDto;
import com.example.astrotalk.entity.Patient;
import com.example.astrotalk.exception.BadRequest;
import com.example.astrotalk.exception.PatientNotFound;
import com.example.astrotalk.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<PatientDto>> getAllPatient(String sortBy, int pageNo, int pageSize, String sortOrder){
        Pageable pageable;
        switch (sortBy) {
            case "name" :
                if(sortOrder.equals("asc"))
                    pageable = PageRequest.of(pageNo, pageSize, Sort.by("name").ascending());
                else {
                    pageable = PageRequest.of(pageNo, pageSize, Sort.by("name").descending());
                }
            break;
            case "age" :
                if(sortOrder.equals("asc"))
                pageable = PageRequest.of(pageNo, pageSize, Sort.by("age").ascending());
                else {
                    pageable = PageRequest.of(pageNo, pageSize, Sort.by("age").descending());
                }
                break;
            default: pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        }
        Page<Patient> patients = patientRepository.findAll(pageable);
        List<Patient> patientList = patients.toList();
        List<PatientDto> patientData = patientList.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(patientData);
    }

    public ResponseEntity<PatientDto> addPatient(CreatePatientDto createPatientDto){
        Patient patient;
        try {
            patient = modelMapper.map(createPatientDto, Patient.class);
        }
        catch (Exception e){
            throw new BadRequest("Bad Request");
        }
        String key = UUID.randomUUID().toString();
        patient.setStatus(true);
        patient.setPatientKey(key);
        patient.setAdmitDate(LocalDate.now());
        Patient newPatient = patientRepository.save(patient);
        return ResponseEntity.ok(modelMapper.map(newPatient,PatientDto.class));
    }

    public ResponseEntity<PatientDto> dischargePatient(String patientKey){
        Patient existedPatient = patientRepository.findByPatientKey(patientKey);
        if(existedPatient==null)
            throw new PatientNotFound("Patient does not exist");
        existedPatient.setStatus(false);
        Patient patient = patientRepository.save(existedPatient);
        return ResponseEntity.ok(modelMapper.map(patient, PatientDto.class));
    }

}
