package com.example.springbootrest.controllers;

import com.example.springbootrest.models.JobPost;
import com.example.springbootrest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable int jobId) {
        return jobService.getJob(jobId);
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return jobService.searchByKeyword(keyword);
    }

    @PostMapping(path = "jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        jobService.deleteJob(jobId);
        return "Deleted successfully";
    }

    @GetMapping("load")
    public String loadData() {
        jobService.loadData();
        return "success";
    }
}
