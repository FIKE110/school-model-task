package com.school.model;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for Person validation and edge cases
 */
class PersonEdgeCaseTest {

    @Test
    void personShouldRejectNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student(null, "John", 16);
        });
    }

    @Test
    void personShouldRejectEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("", "John", 16);
        });
    }

    @Test
    void personShouldRejectNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("STU001", null, 16);
        });
    }

    @Test
    void personShouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("STU001", "", 16);
        });
    }

    @Test
    void personShouldRejectNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("STU001", "John", -1);
        });
    }

    @Test
    void personShouldRejectNullNameInSetter() {
        Student student = new Student("STU001", "John", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            student.setName(null);
        });
    }

    @Test
    void personShouldRejectNegativeAgeInSetter() {
        Student student = new Student("STU001", "John", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(-1);
        });
    }

    @Test
    void studentShouldRejectNullCourse() {
        Student student = new Student("STU001", "John", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            student.takeCourse(null);
        });
    }

    @Test
    void studentShouldRemoveCourse() {
        Student student = new Student("STU001", "John", 16);
        Course course = new Course("MATH101", "Math", "Basic math");
        student.takeCourse(course);
        assertEquals(1, student.getCourses().size());
        
        student.removeCourse(course);
        assertEquals(0, student.getCourses().size());
    }

    @Test
    void personsWithSameIdShouldBeEqual() {
        Student student1 = new Student("STU001", "John", 16);
        Student student2 = new Student("STU001", "Jane", 17);
        assertEquals(student1, student2);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void personsWithDifferentIdsShouldNotBeEqual() {
        Student student1 = new Student("STU001", "John", 16);
        Student student2 = new Student("STU002", "John", 16);
        assertNotEquals(student1, student2);
    }

    @Test
    void personShouldNotEqualNull() {
        Student student = new Student("STU001", "John", 16);
        assertNotEquals(student, null);
    }

    @Test
    void personShouldNotEqualDifferentType() {
        Student student = new Student("STU001", "John", 16);
        assertNotEquals(student, "Not a student");
    }

    @Test
    void personToStringShouldContainInfo() {
        Student student = new Student("STU001", "John", 16);
        String str = student.toString();
        assertTrue(str.contains("STU001"));
        assertTrue(str.contains("John"));
        assertTrue(str.contains("16"));
    }

    @Test
    void studentShouldDefensiveCopyCourses() {
        Student student = new Student("STU001", "John", 16);
        Course course = new Course("MATH101", "Math", "Basic math");
        student.takeCourse(course);
        
        Set<Course> courses = student.getCourses();
        courses.clear();
        
        assertEquals(1, student.getCourses().size());
    }
}
