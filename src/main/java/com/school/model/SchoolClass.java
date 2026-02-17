package com.school.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * SchoolClass entity representing a grade/class in the school
 */
public class SchoolClass {
    private final String name;
    private final int gradeLevel;
    private final Set<Student> students;
    private Teacher classTeacher;

    public SchoolClass(String name, int gradeLevel) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be null or empty");
        }
        if (gradeLevel < 1 || gradeLevel > 12) {
            throw new IllegalArgumentException("Grade level must be between 1 and 12");
        }
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (students.add(student)) {
            student.setAssignedClass(this);
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            student.setAssignedClass(null);
        }
    }

    public int getStudentCount() {
        return students.size();
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolClass that = (SchoolClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("SchoolClass{name='%s', gradeLevel=%d, students=%d}",
                name, gradeLevel, students.size());
    }
}
