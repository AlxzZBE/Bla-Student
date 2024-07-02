package com.alex.spring.bla_students.requests;

import com.alex.spring.bla_students.entities.Student;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class StudentGetRequest {

    private String name;
    private String lastName;
    private String cpf;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;
    private String phoneNumber;
    private String currentBelt;
    private String currentGroup;
    private String currentCourse;
    private String paymentMethod;
    private String registrationDate;
    private Boolean active;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public StudentGetRequest(Student student) {
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.cpf = student.getCpf();
        this.email = student.getEmail();
        this.birthDate = student.getBirthDate();
        this.phoneNumber = student.getPhoneNumber();
        this.currentBelt = student.getCurrentBelt();
        this.currentGroup = student.getCurrentGroup();
        this.currentCourse = student.getCurrentCourse();
        this.paymentMethod = student.getPaymentMethod();
        this.registrationDate = student.getRegistrationDate();
        this.active = student.getActive();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();
        this.state = student.getAddress().getState();
        this.country = student.getAddress().getCountry();
        this.postalCode = student.getAddress().getPostalCode();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCurrentBelt() {
        return currentBelt;
    }

    public String getCurrentGroup() {
        return currentGroup;
    }

    public String getCurrentCourse() {
        return currentCourse;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
