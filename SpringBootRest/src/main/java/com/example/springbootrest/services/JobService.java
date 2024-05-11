package com.example.springbootrest.services;

import com.example.springbootrest.models.JobPost;
import com.example.springbootrest.repositories.JobRepository;
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

    public JobPost getJob(int jobId) {
        return jobRepository.getJob(jobId);
    }

    public List<JobPost> getAllJobs() {
        return jobRepository.findAll();
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.updateJob(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepository.deleteJob(jobId);
    }
}
