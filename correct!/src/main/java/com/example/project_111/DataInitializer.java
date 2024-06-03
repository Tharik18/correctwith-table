/*package com.example.project_111;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.project_111.Entity.Teacher;
import com.example.project_111.Repository.TeacherRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("John");
        teacher1.setLastname("Doe");
        teacher1.setEmail("john.doe@example.com");
        teacher1.setPhone("1234567890");
        teacher1.setCourses(Arrays.asList("Math", "Science"));
        teacher1.setAvailability(Arrays.asList("9:00 AM - 11:00 AM", "1:00 PM - 3:00 PM"));

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Jane");
        teacher2.setLastname("Smith");
        teacher2.setEmail("jane.smith@example.com");
        teacher2.setPhone("0987654321");
        teacher2.setCourses(Arrays.asList("English", "History"));
        teacher2.setAvailability(Arrays.asList("10:00 AM - 12:00 PM", "2:00 PM - 4:00 PM"));

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
    }
}*/
