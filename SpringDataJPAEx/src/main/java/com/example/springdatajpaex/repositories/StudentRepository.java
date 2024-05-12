package com.example.springdatajpaex.repositories;

import com.example.springdatajpaex.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByMarksGreaterThan(int marks);

}
