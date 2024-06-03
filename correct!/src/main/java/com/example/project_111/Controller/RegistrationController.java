package com.example.project_111.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        // Add any required attributes to the model here
        return "registration";  // This should correspond to registration.html in the templates directory
    }

    @GetMapping("/studentDetails")
    public String showStudentDetailsPage(Model model) {
        // Add any required attributes to the model here
        return "studentDetails";  // This should correspond to studentDetails.html in the templates directory
    }
}
