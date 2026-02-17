package com.school.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Course entity
 */
class CourseTest {

    @Test
    void courseShouldHaveCodeNameAndDescription() {
        Course course = new Course("CS101", "Computer Science", "Intro to programming");
        
        assertEquals("CS101", course.getCode());
        assertEquals("Computer Science", course.getName());
        assertEquals("Intro to programming", course.getDescription());
    }

    @Test
    void courseShouldImplementTeachable() {
        Course course = new Course("BIO101", "Biology", "Life sciences");
        
        assertTrue(course instanceof com.school.interfaces.Teachable);
    }

    @Test
    void coursesWithSameCodeShouldBeEqual() {
        Course course1 = new Course("CHEM101", "Chemistry", "Basic chemistry");
        Course course2 = new Course("CHEM101", "Chemistry Advanced", "More chemistry");
        
        assertEquals(course1, course2);
        assertEquals(course1.hashCode(), course2.hashCode());
    }
}
