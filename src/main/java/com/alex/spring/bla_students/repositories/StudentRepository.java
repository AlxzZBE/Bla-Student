package com.alex.spring.bla_students.repositories;

import com.alex.spring.bla_students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCpf(String cpf);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByPhoneNumber(String phoneNumber);
}
