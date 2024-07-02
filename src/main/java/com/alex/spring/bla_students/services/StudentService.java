package com.alex.spring.bla_students.services;

import com.alex.spring.bla_students.entities.Address;
import com.alex.spring.bla_students.entities.Student;
import com.alex.spring.bla_students.repositories.StudentRepository;
import com.alex.spring.bla_students.requests.StudentPostRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findByCpf(String cpf) {
        return studentRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Student with cpf `%s`".formatted(cpf)));
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Student with email `%s`".formatted(email)));
    }

    public Student findByPhoneNumber(String phoneNumber) {
        return studentRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Student with phoneNumber `%s`".formatted(phoneNumber)));
    }

    public Student createStudent(StudentPostRequest studentPostRequest) {
        if (studentRepository.findByCpf(studentPostRequest.getCpf()).isPresent())
            throw new IllegalArgumentException("The value of field `cpf` already exists!");
        if (studentRepository.findByEmail(studentPostRequest.getEmail()).isPresent())
            throw new IllegalArgumentException("The value of field `email` already exists!");
        if (studentRepository.findByPhoneNumber(studentPostRequest.getPhoneNumber()).isPresent())
            throw new IllegalArgumentException("The value of field `phoneNumber` already exists!");

        Student newStudent = new Student();
        newStudent.setName(studentPostRequest.getName());
        newStudent.setLastName(studentPostRequest.getLastName());
        newStudent.setCpf(studentPostRequest.getCpf());
        newStudent.setEmail(studentPostRequest.getEmail());
        newStudent.setBirthDate(studentPostRequest.getBirthDate());
        newStudent.setPhoneNumber(studentPostRequest.getPhoneNumber());
        newStudent.setCurrentBelt(studentPostRequest.getCurrentBelt());
        newStudent.setCurrentGroup(studentPostRequest.getCurrentGroup());
        newStudent.setCurrentCourse(studentPostRequest.getCurrentCourse());
        newStudent.setPaymentMethod(studentPostRequest.getPaymentMethod());
        newStudent.setRegistrationDate(studentPostRequest.getRegistrationDate());
        newStudent.setActive(studentPostRequest.getActive());

        Address newAddress = new Address();
        newAddress.setStreet(studentPostRequest.getStreet());
        newAddress.setCity(studentPostRequest.getCity());
        newAddress.setState(studentPostRequest.getState());
        newAddress.setCountry(studentPostRequest.getCountry());
        newAddress.setPostalCode(studentPostRequest.getPostalCode());
        newAddress.setStudent(newStudent);

        newStudent.setAddress(newAddress);
        return newStudent;
    }

}

