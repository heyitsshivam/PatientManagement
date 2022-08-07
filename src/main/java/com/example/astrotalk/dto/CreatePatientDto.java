package com.example.astrotalk.dto;

import java.time.LocalDate;

public class CreatePatientDto {

    private String patientKey;
    private String name;
    private int age;
    private int room;
    private String doctorName;
    private Double expenses;

    public CreatePatientDto() {
    }

    public CreatePatientDto(String patientKey,String name, int age, int room, String doctorName, Double expenses) {
        this.patientKey = patientKey;
        this.name = name;
        this.age = age;
        this.room = room;
        this.doctorName = doctorName;
        this.expenses = expenses;
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


    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "CreatePatientDto{" +
                "patientKey='" + patientKey + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", room=" + room +
                ", doctorName='" + doctorName + '\'' +
                ", expenses=" + expenses +
                '}';
    }
}
