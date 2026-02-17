package com.school.interfaces;

/**
 * Interface for staff members who can teach courses
 */
public interface TeachingStaff {
    void assignCourse(com.school.model.Course course);
    void teach();
    boolean canTeach(com.school.model.Course course);
}
