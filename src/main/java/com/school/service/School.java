package com.school.service;

import com.school.model.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * School management system that manages all school entities
 */
public class School {
    private final String name;
    private final Set<Student> students;
    private final Set<Staff> staff;
    private final Set<Course> courses;
    private final Set<SchoolClass> classes;
    private Principal principal;

    public School(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("School name cannot be null or empty");
        }
        this.name = name;
        this.students = new HashSet<>();
        this.staff = new HashSet<>();
        this.courses = new HashSet<>();
        this.classes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Set<Staff> getStaff() {
        return new HashSet<>(staff);
    }

    public void addStaff(Staff staffMember) {
        if (staffMember == null) {
            throw new IllegalArgumentException("Staff member cannot be null");
        }
        staff.add(staffMember);
        if (staffMember instanceof Principal) {
            this.principal = (Principal) staffMember;
        }
    }

    public void removeStaff(Staff staffMember) {
        staff.remove(staffMember);
        if (staffMember instanceof Principal && staffMember.equals(principal)) {
            this.principal = null;
        }
    }

    public Set<Course> getCourses() {
        return new HashSet<>(courses);
    }

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Set<SchoolClass> getClasses() {
        return new HashSet<>(classes);
    }

    public void addClass(SchoolClass schoolClass) {
        if (schoolClass == null) {
            throw new IllegalArgumentException("School class cannot be null");
        }
        classes.add(schoolClass);
    }

    public void removeClass(SchoolClass schoolClass) {
        classes.remove(schoolClass);
    }

    public void assignTeacherToClass(Teacher teacher, SchoolClass schoolClass) {
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher cannot be null");
        }
        if (schoolClass == null) {
            throw new IllegalArgumentException("School class cannot be null");
        }
        if (!staff.contains(teacher)) {
            throw new IllegalStateException("Teacher must be employed by the school");
        }
        if (!classes.contains(schoolClass)) {
            throw new IllegalStateException("School class must be registered");
        }
        schoolClass.setClassTeacher(teacher);
    }

    public void enrollStudentInClass(Student student, SchoolClass schoolClass) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (schoolClass == null) {
            throw new IllegalArgumentException("School class cannot be null");
        }
        if (!students.contains(student)) {
            throw new IllegalStateException("Student must be enrolled in the school");
        }
        if (!classes.contains(schoolClass)) {
            throw new IllegalStateException("School class must be registered");
        }
        schoolClass.addStudent(student);
    }

    public int getStudentCount() {
        return students.size();
    }

    public int getStaffCount() {
        return staff.size();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public int getClassCount() {
        return classes.size();
    }

    public Principal getPrincipal() {
        return principal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("School{name='%s', students=%d, staff=%d, courses=%d, classes=%d}",
                name, students.size(), staff.size(), courses.size(), classes.size());
    }
}
