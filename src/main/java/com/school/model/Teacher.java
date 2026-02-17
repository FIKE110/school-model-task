package com.school.model;

import com.school.interfaces.TeachingStaff;
import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity that can teach courses
 */
public class Teacher extends Staff implements TeachingStaff {
    private final Set<Course> assignedCourses;

    public Teacher(String id, String name, int age, String department) {
        super(id, name, age, department);
        this.assignedCourses = new HashSet<>();
    }

    @Override
    public void assignCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        assignedCourses.add(course);
    }

    @Override
    public void teach() {
        if (assignedCourses.isEmpty()) {
            System.out.println(name + " is not assigned to any course yet");
        } else {
            System.out.println(name + " is teaching: " + assignedCourses);
        }
    }

    @Override
    public boolean canTeach(Course course) {
        return course != null && assignedCourses.contains(course);
    }

    public Set<Course> getAssignedCourses() {
        return new HashSet<>(assignedCourses);
    }

    public void removeCourse(Course course) {
        assignedCourses.remove(course);
    }

    @Override
    public void performDuty() {
        teach();
    }
}
