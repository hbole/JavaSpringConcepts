package com.example.springbootrest.services;

import com.example.springbootrest.models.JobPost;
import com.example.springbootrest.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public JobPost getJob(int jobId) {
        Optional<JobPost> optionalJobPost = jobRepository.findById(jobId);
        if(optionalJobPost.isEmpty()) {
            return new JobPost();
        }

        return optionalJobPost.get();
    }

    public List<JobPost> getAllJobs() {
        return jobRepository.findAll();
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepository.deleteById(jobId);
    }

    public void loadData() {
        List<JobPost> jobPosts = new ArrayList<>();

        // Java Developer Job Post
        jobPosts.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobPosts.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobPosts.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobPosts.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobPosts.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));

        jobRepository.saveAll(jobPosts);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return  jobRepository.findByPostProfileContainingOrPostDesContaining(keyword, keyword);
    }
}
