package com.example.astrotalk.service;

import com.example.astrotalk.dto.CreatePatientDto;
import com.example.astrotalk.dto.PatientDto;
import com.example.astrotalk.entity.Patient;
import com.example.astrotalk.exception.BadRequest;
import com.example.astrotalk.exception.PatientNotFound;
import com.example.astrotalk.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<PatientDto>> getAllPatient(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientList = patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(patientList);
    }

    public ResponseEntity<CreatePatientDto> addPatient(CreatePatientDto createPatientDto){
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
        patientRepository.save(patient);
        return ResponseEntity.ok(modelMapper.map(patient,CreatePatientDto.class));
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
