package com.example.project_111.Controller;

public class ChangeTimingRequest {
    private Long studentId;
    private String newTiming;

    // Getters and setters
    
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNewTiming() {
        return newTiming;
    }

    public void setNewTiming(String newTiming) {
        this.newTiming = newTiming;
    }
}