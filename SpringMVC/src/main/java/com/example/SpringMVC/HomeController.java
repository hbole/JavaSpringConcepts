package com.example.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("Home method called in jsp...");
        return "index";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView modelAndView) {
        int result = num1 + num2;

        modelAndView.addObject("result", result);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        return "result";
    }
}
