package com.example.astrotalk.entity;

import com.example.astrotalk.audit.AuditImpl;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospital_patient")
public class Patient extends AuditImpl {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String patientKey;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private int room;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private LocalDate admitDate;
    @Column(nullable = false)
    private Double expenses;
    @Column(nullable = false)
    private boolean Status;

    public Patient() {
    }

    public Patient(String patientKey, String name, int age, int room, String doctorName, LocalDate admitDate, Double expenses, boolean status) {
        this.patientKey = patientKey;
        this.name = name;
        this.age = age;
        this.room = room;
        this.doctorName = doctorName;
        this.admitDate = admitDate;
        this.expenses = expenses;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patientKey='" + patientKey + '\'' +
                ", age=" + age +
                ", room=" + room +
                ", doctorName='" + doctorName + '\'' +
                ", admitDate=" + admitDate +
                ", expenses=" + expenses +
                ", Status=" + Status +
                '}';
    }
}
