package com.example.springdatajpaex;

import com.example.springdatajpaex.models.Student;
import com.example.springdatajpaex.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaExApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);
        StudentRepository studentRepository = context.getBean(StudentRepository.class);

        s1.setRollNo(101);
        s1.setName("Harshit");
        s1.setMarks(87);

        s2.setRollNo(102);
        s2.setName("Karan");
        s2.setMarks(45);

        s3.setRollNo(103);
        s3.setName("Karthik");
        s3.setMarks(77);

        studentRepository.delete(s1);
        studentRepository.delete(s2);
        studentRepository.delete(s3);

        System.out.println(studentRepository.findByName("Harshit"));
        System.out.println(studentRepository.findByMarksGreaterThan(70));
    }

}
