package com.example.springbootrest.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity(name = "job_posts")
public class JobPost {
    @Id
    private int postId;

    private String postProfile;
    private String postDes;
    private int reqExperience;

    @ElementCollection
    private List<String> postTechStack;
}
