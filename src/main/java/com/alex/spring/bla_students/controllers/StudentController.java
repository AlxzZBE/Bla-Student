package com.alex.spring.bla_students.controllers;

import com.alex.spring.bla_students.requests.StudentGetRequest;
import com.alex.spring.bla_students.requests.StudentPostRequest;
import com.alex.spring.bla_students.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentGetRequest> saveStudent(@RequestBody @Valid StudentPostRequest studentPostRequest) {
        return ResponseEntity.ok(new StudentGetRequest(studentService.save(studentService.createStudent(studentPostRequest))));
    }

    @GetMapping(params = "cpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentGetRequest> getStudentByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(new StudentGetRequest(studentService.findByCpf(cpf)));
    }

    @GetMapping(params = "email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentGetRequest> getStudentByEmail(@RequestParam String email) {
        return ResponseEntity.ok(new StudentGetRequest(studentService.findByEmail(email)));
    }

    @GetMapping(params = "phoneNumber", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentGetRequest> getStudentByPhoneNumber(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(new StudentGetRequest(studentService.findByPhoneNumber(phoneNumber)));
    }
}
