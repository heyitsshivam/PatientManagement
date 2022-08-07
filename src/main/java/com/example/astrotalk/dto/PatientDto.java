package com.example.astrotalk.dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class PatientDto {

    private String patientKey;
    private String name;
    private int age;
    private int room;
    private String doctorName;
    private LocalDate admitDate;
    private Double expenses;
    private boolean Status;

    public PatientDto() {
    }

    public PatientDto(String patientKey, String name, int age, int room, String doctorName, LocalDate admitDate, Double expenses, boolean status) {
        this.patientKey = patientKey;
        this.name = name;
        this.age = age;
        this.room = room;
        this.doctorName = doctorName;
        this.admitDate = admitDate;
        this.expenses = expenses;
        Status = status;
    }

    public String getPatientKey() {
        return patientKey;
    }

    public void setPatientKey(String patientKey) {
        this.patientKey = patientKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(LocalDate admitDate) {
        this.admitDate = admitDate;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "patientKey='" + patientKey + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", room=" + room +
                ", doctorName='" + doctorName + '\'' +
                ", admitDate=" + admitDate +
                ", expenses=" + expenses +
                ", Status=" + Status +
                '}';
    }
}
