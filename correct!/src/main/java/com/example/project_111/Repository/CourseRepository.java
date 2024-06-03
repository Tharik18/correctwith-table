package com.example.project_111.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_111.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}