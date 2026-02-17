package com.school.service;

import com.school.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for School management system
 */
class SchoolTest {
    
    private School school;
    private Principal principal;
    private Teacher teacher;
    private Student student;
    private Course course;
    private SchoolClass schoolClass;

    @BeforeEach
    void setUp() {
        school = new School("Lincoln High School");
        principal = new Principal("PRN001", "Dr. Smith", 55, "Administration");
        teacher = new Teacher("TCH001", "Mr. Brown", 45, "Science");
        student = new Student("STU001", "Jane Doe", 16);
        course = new Course("SCI101", "General Science", "Basic science concepts");
        schoolClass = new SchoolClass("Grade 10A", 10);
    }

    @Test
    void schoolShouldHaveName() {
        assertEquals("Lincoln High School", school.getName());
    }

    @Test
    void schoolShouldAddStudent() {
        school.addStudent(student);
        
        assertTrue(school.getStudents().contains(student));
    }

    @Test
    void schoolShouldRemoveStudent() {
        school.addStudent(student);
        school.removeStudent(student);
        
        assertFalse(school.getStudents().contains(student));
    }

    @Test
    void schoolShouldAddStaff() {
        school.addStaff(teacher);
        
        assertTrue(school.getStaff().contains(teacher));
    }

    @Test
    void schoolShouldAddCourse() {
        school.addCourse(course);
        
        assertTrue(school.getCourses().contains(course));
    }

    @Test
    void schoolShouldAddClass() {
        school.addClass(schoolClass);
        
        assertTrue(school.getClasses().contains(schoolClass));
    }

    @Test
    void schoolShouldAssignTeacherToClass() {
        school.addStaff(teacher);
        school.addClass(schoolClass);
        
        school.assignTeacherToClass(teacher, schoolClass);
        
        assertEquals(teacher, schoolClass.getClassTeacher());
    }

    @Test
    void schoolShouldEnrollStudentInClass() {
        school.addStudent(student);
        school.addClass(schoolClass);
        
        school.enrollStudentInClass(student, schoolClass);
        
        assertTrue(schoolClass.getStudents().contains(student));
    }

    @Test
    void schoolShouldGetTotalCounts() {
        school.addStudent(student);
        school.addStaff(teacher);
        school.addCourse(course);
        
        assertEquals(1, school.getStudentCount());
        assertEquals(1, school.getStaffCount());
        assertEquals(1, school.getCourseCount());
    }

    @Test
    void schoolShouldNotAddDuplicateStudent() {
        school.addStudent(student);
        school.addStudent(student);
        
        assertEquals(1, school.getStudentCount());
    }
}
