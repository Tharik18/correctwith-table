package com.example.project_111.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project_111.Entity.Student;
import com.example.project_111.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<String> getTeacherAvailability(Long teacherId) {
        // Example: return List.of("9:00 - 10:00", "14:00 - 15:00", "16:00 - 17:00");
        return List.of("9:00 - 10:00", "14:00 - 15:00", "16:00 - 17:00"); // Placeholder implementation
    }

    public boolean isTimingAvailable(String course, Long teacherId, String timing) {
        List<Student> students = studentRepository.findByCourseAndTeacherIdAndTiming(course, teacherId, timing);
        return students.isEmpty();
    }

    public String save(Student student) {
        if (isTimingAvailable(student.getCourse(), student.getTeacherId(), student.getTiming())) {
            studentRepository.save(student);
            return "Student registered successfully!";
        } else {
            return "Selected timing is not available. Kindly select another timing.";
        }
    }

    public String changeStudentTiming(Long studentId, String newTiming) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            LocalTime currentTime = LocalTime.now();

            try {
                // Extract the start time from the timing range
                String[] timingParts = student.getTiming().trim().split(" - ");
                LocalTime studentTiming = LocalTime.parse(timingParts[0].trim(), TIME_FORMATTER);

                String[] newTimingParts = newTiming.trim().split(" - ");
                LocalTime newTimingParsed = LocalTime.parse(newTimingParts[0].trim(), TIME_FORMATTER);

                long hoursUntilClass = java.time.Duration.between(currentTime, studentTiming).toHours();

                if (hoursUntilClass < 12) {
                    return "Sorry, only possible before 12 hours.";
                }

                if (isTimingAvailable(student.getCourse(), student.getTeacherId(), newTiming)) {
                    student.setTiming(newTiming);
                    studentRepository.save(student);
                    return "Timing updated successfully!";
                } else {
                    return "No other timing available.";
                }
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                return "Error parsing timing: " + e.getMessage();
            }
        } else {
            return "Student not found.";
        }
    }
}
