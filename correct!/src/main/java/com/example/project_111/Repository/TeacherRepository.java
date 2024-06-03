package com.example.project_111.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_111.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByCoursesContaining(String course);
}
