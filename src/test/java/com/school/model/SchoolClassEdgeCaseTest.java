package com.school.model;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for SchoolClass edge cases
 */
class SchoolClassEdgeCaseTest {

    @Test
    void schoolClassShouldRejectNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SchoolClass(null, 10);
        });
    }

    @Test
    void schoolClassShouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SchoolClass("", 10);
        });
    }

    @Test
    void schoolClassShouldRejectGradeLevelTooLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SchoolClass("Grade 0", 0);
        });
    }

    @Test
    void schoolClassShouldRejectGradeLevelTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SchoolClass("Grade 13", 13);
        });
    }

    @Test
    void schoolClassShouldRejectNullStudent() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        assertThrows(IllegalArgumentException.class, () -> {
            schoolClass.addStudent(null);
        });
    }

    @Test
    void schoolClassShouldRemoveStudent() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        Student student = new Student("STU001", "John", 16);
        schoolClass.addStudent(student);
        assertEquals(1, schoolClass.getStudentCount());
        
        schoolClass.removeStudent(student);
        assertEquals(0, schoolClass.getStudentCount());
    }

    @Test
    void schoolClassShouldDefensiveCopyStudents() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        Student student = new Student("STU001", "John", 16);
        schoolClass.addStudent(student);
        
        Set<Student> students = schoolClass.getStudents();
        students.clear();
        
        assertEquals(1, schoolClass.getStudentCount());
    }

    @Test
    void schoolClassShouldNotEqualNull() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        assertNotEquals(schoolClass, null);
    }

    @Test
    void schoolClassShouldNotEqualDifferentType() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        assertNotEquals(schoolClass, "Grade 10A");
    }

    @Test
    void schoolClassesWithDifferentNamesShouldNotBeEqual() {
        SchoolClass class1 = new SchoolClass("Grade 10A", 10);
        SchoolClass class2 = new SchoolClass("Grade 10B", 10);
        assertNotEquals(class1, class2);
    }

    @Test
    void schoolClassToStringShouldContainInfo() {
        SchoolClass schoolClass = new SchoolClass("Grade 10A", 10);
        Student student = new Student("STU001", "John", 16);
        schoolClass.addStudent(student);
        
        String str = schoolClass.toString();
        assertTrue(str.contains("Grade 10A"));
        assertTrue(str.contains("10"));
    }
}
