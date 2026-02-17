package com.school.model;

import com.school.service.School;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for Course edge cases
 */
class CourseEdgeCaseTest {

    @Test
    void courseShouldRejectNullCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course(null, "Math", "Description");
        });
    }

    @Test
    void courseShouldRejectEmptyCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course("", "Math", "Description");
        });
    }

    @Test
    void courseShouldRejectNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course("MATH101", null, "Description");
        });
    }

    @Test
    void courseShouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course("MATH101", "", "Description");
        });
    }

    @Test
    void courseShouldRejectNullNameInSetter() {
        Course course = new Course("MATH101", "Math", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            course.setName(null);
        });
    }

    @Test
    void courseShouldAllowNullDescription() {
        Course course = new Course("MATH101", "Math", null);
        assertNull(course.getDescription());
    }

    @Test
    void courseShouldSetDescription() {
        Course course = new Course("MATH101", "Math", "Old description");
        course.setDescription("New description");
        assertEquals("New description", course.getDescription());
    }

    @Test
    void courseToStringShouldContainInfo() {
        Course course = new Course("MATH101", "Math", "Description");
        String str = course.toString();
        assertTrue(str.contains("MATH101"));
        assertTrue(str.contains("Math"));
    }

    @Test
    void courseShouldNotEqualNull() {
        Course course = new Course("MATH101", "Math", "Description");
        assertNotEquals(course, null);
    }

    @Test
    void courseShouldNotEqualDifferentType() {
        Course course = new Course("MATH101", "Math", "Description");
        assertNotEquals(course, "MATH101");
    }

    @Test
    void coursesWithDifferentCodesShouldNotBeEqual() {
        Course course1 = new Course("MATH101", "Math", "Desc1");
        Course course2 = new Course("SCI101", "Science", "Desc2");
        assertNotEquals(course1, course2);
    }
}
