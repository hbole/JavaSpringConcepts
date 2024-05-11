package com.example.jobapp.repositories;

import com.example.jobapp.models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository {
    List<JobPost> jobPosts = new ArrayList<>();

    public List<JobPost> findAll() {
        return jobPosts;
    }

    public void save(JobPost jobPost) {
        jobPosts.add(jobPost);
        System.out.println(jobPosts);
    }
}
