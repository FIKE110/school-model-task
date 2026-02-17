package com.school.service;

import com.school.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for School edge cases and validation
 */
class SchoolEdgeCaseTest {

    private School school;

    @BeforeEach
    void setUp() {
        school = new School("Test School");
    }

    @Test
    void schoolShouldRejectNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new School(null);
        });
    }

    @Test
    void schoolShouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new School("");
        });
    }

    @Test
    void schoolShouldRejectNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            school.addStudent(null);
        });
    }

    @Test
    void schoolShouldRejectNullStaff() {
        assertThrows(IllegalArgumentException.class, () -> {
            school.addStaff(null);
        });
    }

    @Test
    void schoolShouldRejectNullCourse() {
        assertThrows(IllegalArgumentException.class, () -> {
            school.addCourse(null);
        });
    }

    @Test
    void schoolShouldRejectNullClass() {
        assertThrows(IllegalArgumentException.class, () -> {
            school.addClass(null);
        });
    }

    @Test
    void schoolShouldRejectAssigningNonExistentTeacher() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addClass(schoolClass);
        
        assertThrows(IllegalStateException.class, () -> {
            school.assignTeacherToClass(teacher, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectAssigningTeacherToNonExistentClass() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addStaff(teacher);
        
        assertThrows(IllegalStateException.class, () -> {
            school.assignTeacherToClass(teacher, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectEnrollingNonExistentStudent() {
        Student student = new Student("STU001", "John", 16);
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addClass(schoolClass);
        
        assertThrows(IllegalStateException.class, () -> {
            school.enrollStudentInClass(student, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectEnrollingStudentInNonExistentClass() {
        Student student = new Student("STU001", "John", 16);
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addStudent(student);
        
        assertThrows(IllegalStateException.class, () -> {
            school.enrollStudentInClass(student, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectNullTeacherAssignment() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addClass(schoolClass);
        
        assertThrows(IllegalArgumentException.class, () -> {
            school.assignTeacherToClass(null, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectNullClassAssignment() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        school.addStaff(teacher);
        
        assertThrows(IllegalArgumentException.class, () -> {
            school.assignTeacherToClass(teacher, null);
        });
    }

    @Test
    void schoolShouldRejectNullStudentEnrollment() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addClass(schoolClass);
        
        assertThrows(IllegalArgumentException.class, () -> {
            school.enrollStudentInClass(null, schoolClass);
        });
    }

    @Test
    void schoolShouldRejectNullClassEnrollment() {
        Student student = new Student("STU001", "John", 16);
        school.addStudent(student);
        
        assertThrows(IllegalArgumentException.class, () -> {
            school.enrollStudentInClass(student, null);
        });
    }

    @Test
    void schoolShouldTrackPrincipal() {
        Principal principal = new Principal("PRN001", "Dr. Smith", 50, "Admin");
        school.addStaff(principal);
        assertEquals(principal, school.getPrincipal());
    }

    @Test
    void schoolShouldRemovePrincipal() {
        Principal principal = new Principal("PRN001", "Dr. Smith", 50, "Admin");
        school.addStaff(principal);
        school.removeStaff(principal);
        assertNull(school.getPrincipal());
    }

    @Test
    void schoolShouldDefensiveCopyStudents() {
        Student student = new Student("STU001", "John", 16);
        school.addStudent(student);
        
        Set<Student> students = school.getStudents();
        students.clear();
        
        assertEquals(1, school.getStudentCount());
    }

    @Test
    void schoolShouldDefensiveCopyStaff() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        school.addStaff(teacher);
        
        Set<Staff> staff = school.getStaff();
        staff.clear();
        
        assertEquals(1, school.getStaffCount());
    }

    @Test
    void schoolShouldDefensiveCopyCourses() {
        Course course = new Course("MATH101", "Math", "Description");
        school.addCourse(course);
        
        Set<Course> courses = school.getCourses();
        courses.clear();
        
        assertEquals(1, school.getCourseCount());
    }

    @Test
    void schoolShouldDefensiveCopyClasses() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        school.addClass(schoolClass);
        
        Set<SchoolClass> classes = school.getClasses();
        classes.clear();
        
        assertEquals(1, school.getClassCount());
    }

    @Test
    void schoolsWithSameNameShouldBeEqual() {
        School school1 = new School("Same Name");
        School school2 = new School("Same Name");
        assertEquals(school1, school2);
        assertEquals(school1.hashCode(), school2.hashCode());
    }

    @Test
    void schoolsWithDifferentNamesShouldNotBeEqual() {
        School school1 = new School("School One");
        School school2 = new School("School Two");
        assertNotEquals(school1, school2);
    }

    @Test
    void schoolShouldNotEqualNull() {
        assertNotEquals(school, null);
    }

    @Test
    void schoolShouldNotEqualDifferentType() {
        assertNotEquals(school, "Test School");
    }

    @Test
    void schoolToStringShouldContainInfo() {
        Student student = new Student("STU001", "John", 16);
        school.addStudent(student);
        
        String str = school.toString();
        assertTrue(str.contains("Test School"));
        assertTrue(str.contains("students=1"));
    }
}
