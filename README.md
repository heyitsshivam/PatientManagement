# PatientManagement <br>
Internal H2 database is used for user security management and patient management <br>
for create user/staff: localhost:8080/create  <br> user data format is <br> {"fullName":"shivam",
"phoneNo":"1234567890",
"email":"shivam@gmail.com",
"password":"shivam"} <br> 
for get patients : localhost:8080/get <br>
for create patients : localhost:8080/add <br>
Patient data format is  <br>{
    "name":"shivam",
    "age":22,
    "room":101,
    "doctorName":"dr kashmiri",
    "admitDate":"2022-04-21",
    "expenses":2300.12
} <br> and username and password should be provided to access patient rest api's <br>
for discharge patient: localhost:8080/discharge <br>
 if Status is true: Patient admitted <br>
 If status is false: Patient Discharged <br>

