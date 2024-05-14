package com.example.springbootrest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
