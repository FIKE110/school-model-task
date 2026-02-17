package com.school.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity that can take courses
 */
public class Student extends Person {
    private final Set<Course> courses;
    private SchoolClass assignedClass;

    public Student(String id, String name, int age) {
        super(id, name, age);
        this.courses = new HashSet<>();
    }

    public void takeCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        courses.add(course);
    }

    public Set<Course> getCourses() {
        return new HashSet<>(courses);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public SchoolClass getAssignedClass() {
        return assignedClass;
    }

    void setAssignedClass(SchoolClass schoolClass) {
        this.assignedClass = schoolClass;
    }
}
