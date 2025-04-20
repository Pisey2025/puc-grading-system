package com.puc.grading;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String processForm(@RequestParam String studentID,
                              @RequestParam String name,
                              @RequestParam String subject,
                              @RequestParam int score,
                              Model model) {

        // Validate score
        if (score < 0 || score > 100) {
            model.addAttribute("error", "Score must be between 0 and 100.");
            return "form";
        }

        // Determine grade
        String grade;
        if (score >= 90) grade = "A";
        else if (score >= 80) grade = "B";
        else if (score >= 70) grade = "C";
        else if (score >= 60) grade = "D";
        else grade = "Fail";

        // Add attributes to model for result display
        model.addAttribute("studentID", studentID);
        model.addAttribute("name", name);
        model.addAttribute("subject", subject);
        model.addAttribute("score", score);
        model.addAttribute("grade", grade);

        return "result";
    }
}
