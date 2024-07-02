package com.alex.spring.bla_students.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class StudentPostRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank()
    private String cpf;
    @NotBlank
    @Email
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;
    @NotBlank
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

    public @NotBlank String getName() {
        return name;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public @NotBlank String getPhoneNumber() {
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
