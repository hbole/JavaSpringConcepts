package com.example.springbootrest.repositories;

import com.example.springbootrest.models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository {
    List<JobPost> jobPosts = new ArrayList<>();

    public JobRepository() {
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
    }



    public List<JobPost> findAll() {
        return jobPosts;
    }

    public JobPost getJob(int jobId) {
        for(JobPost jobPost : jobPosts) {
            if(jobPost.getPostId() == jobId) {
                return jobPost;
            }
        }
        return null;
    }

    public void save(JobPost jobPost) {
        jobPosts.add(jobPost);
        System.out.println(jobPosts);
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost job : jobPosts) {
            if(jobPost.getPostId() == job.getPostId()) {
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDes(jobPost.getPostDes());
                job.setReqExperience(job.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int jobId) {
        for(JobPost jobPost : jobPosts) {
            if(jobPost.getPostId() == jobId) {
                jobPosts.remove(jobPost);
            }
        }
    }
}
