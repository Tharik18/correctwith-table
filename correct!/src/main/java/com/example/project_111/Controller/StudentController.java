package com.example.project_111.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_111.Entity.Student;
import com.example.project_111.Service.StudentService;

@RestController
@RequestMapping("/api/registration")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/teacher/{teacherId}/availability")
    public List<String> getTeacherAvailability(@PathVariable Long teacherId) {
        return studentService.getTeacherAvailability(teacherId);
    }

    @PostMapping("/student/change-timing")
    public String changeStudentTiming(@RequestBody ChangeTimingRequest request) {
        return studentService.changeStudentTiming(request.getStudentId(), request.getNewTiming());
    }
}
