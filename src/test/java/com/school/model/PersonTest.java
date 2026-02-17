package com.school.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Person base class and subclasses
 */
class PersonTest {

    @Test
    void studentShouldHaveIdNameAndAge() {
        Student student = new Student("STU001", "Alice Johnson", 16);
        
        assertEquals("STU001", student.getId());
        assertEquals("Alice Johnson", student.getName());
        assertEquals(16, student.getAge());
    }

    @Test
    void applicantShouldHaveIdNameAndAge() {
        Applicant applicant = new Applicant("APP001", "Bob Smith", 14);
        
        assertEquals("APP001", applicant.getId());
        assertEquals("Bob Smith", applicant.getName());
        assertEquals(14, applicant.getAge());
    }

    @Test
    void staffShouldHaveIdNameAgeAndRole() {
        Teacher teacher = new Teacher("TCH001", "Mr. Williams", 35, "Mathematics");
        
        assertEquals("TCH001", teacher.getId());
        assertEquals("Mr. Williams", teacher.getName());
        assertEquals(35, teacher.getAge());
        assertEquals("Mathematics", teacher.getDepartment());
    }

    @Test
    void studentShouldBeAbleToTakeCourse() {
        Student student = new Student("STU002", "Charlie Brown", 15);
        Course math = new Course("MATH101", "Mathematics", "Basic algebra and geometry");
        
        student.takeCourse(math);
        
        assertTrue(student.getCourses().contains(math));
    }

    @Test
    void studentShouldNotTakeDuplicateCourse() {
        Student student = new Student("STU003", "David Lee", 17);
        Course physics = new Course("PHY101", "Physics", "Mechanics and thermodynamics");
        
        student.takeCourse(physics);
        student.takeCourse(physics);
        
        assertEquals(1, student.getCourses().size());
    }
}
