package com.example.jobapp.services;

import com.example.jobapp.models.JobPost;
import com.example.jobapp.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepository.findAll();
    }
}
