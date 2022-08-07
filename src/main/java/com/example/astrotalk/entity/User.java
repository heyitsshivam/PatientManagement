package com.example.astrotalk.entity;


import com.example.astrotalk.audit.AuditImpl;

import javax.persistence.*;

@Entity
@Table(name = "hospital_user")
public class User extends AuditImpl {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String phoneNo;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean active;

    public User() {
    }

    public User(String fullName, String role, String email, String phoneNo, String password, boolean active) {
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNo='" + phoneNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}