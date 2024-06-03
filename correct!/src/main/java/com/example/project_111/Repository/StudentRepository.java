package com.example.project_111.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_111.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseAndTeacherIdAndTiming(String course, Long teacherId, String timing);
}
