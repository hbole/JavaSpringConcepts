package com.example.jobapp.controllers;

import com.example.jobapp.models.JobPost;
import com.example.jobapp.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost, Model model) {
        model.addAttribute("jobPost", jobPost);
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobPosts = jobService.getAllJobs();
        model.addAttribute("jobPosts", jobPosts);

        System.out.println("Jobs " + jobPosts);
        return "viewalljobs";
    }
}
