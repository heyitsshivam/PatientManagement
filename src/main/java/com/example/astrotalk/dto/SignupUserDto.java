package com.example.astrotalk.dto;

public class SignupUserDto {

    private String fullName;
    private String phoneNo;
    private String email;
    private String password;

    public SignupUserDto() {
    }

    public SignupUserDto(String fullName, String phoneNo, String email, String password) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "fullName='" + fullName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
