package com.example.project_111.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_111.Entity.Teacher;
import com.example.project_111.Service.TeacherService;

@RestController
@RequestMapping("/api/registration")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/courses")
    public List<String> getAllCourses() {
        return teacherService.getAllCourses();
    }

    @GetMapping("/teachers/{course}")
    public List<Teacher> getTeachersByCourse(@PathVariable String course) {
        return teacherService.getTeachersByCourse(course);
    }

    @GetMapping("/availability/{teacherId}")
    public List<String> getAvailabilityByTeacher(@PathVariable Long teacherId) {
        return teacherService.getAvailabilityByTeacher(teacherId);
    }

    @PostMapping("/register/teacher")
    public String registerTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return "Teacher registered successfully!";
    }
}
