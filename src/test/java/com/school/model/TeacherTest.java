package com.school.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Teacher class and teaching functionality
 */
class TeacherTest {
    
    private Teacher teacher;
    private Course math;
    private Course physics;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("TCH001", "Mrs. Johnson", 40, "Mathematics");
        math = new Course("MATH101", "Mathematics", "Algebra basics");
        physics = new Course("PHY101", "Physics", "Mechanics");
    }

    @Test
    void teacherShouldAssignCourse() {
        teacher.assignCourse(math);
        
        assertTrue(teacher.getAssignedCourses().contains(math));
    }

    @Test
    void teacherShouldTeachAssignedCourse() {
        teacher.assignCourse(math);
        
        assertDoesNotThrow(() -> teacher.teach());
    }

    @Test
    void teacherShouldNotTeachUnassignedCourse() {
        teacher.assignCourse(math);
        
        assertFalse(teacher.canTeach(physics));
        assertTrue(teacher.canTeach(math));
    }

    @Test
    void teacherCanTeachMultipleCourses() {
        teacher.assignCourse(math);
        teacher.assignCourse(new Course("MATH102", "Advanced Math", "Calculus"));
        
        assertEquals(2, teacher.getAssignedCourses().size());
    }
}
