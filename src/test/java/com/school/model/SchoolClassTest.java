package com.school.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for SchoolClass entity
 */
class SchoolClassTest {
    
    private SchoolClass schoolClass;
    private Student student1;
    private Student student2;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        schoolClass = new SchoolClass("Grade 11B", 11);
        student1 = new Student("STU001", "Alice Cooper", 17);
        student2 = new Student("STU002", "Bob Martin", 16);
        teacher = new Teacher("TCH001", "Ms. Garcia", 38, "History");
    }

    @Test
    void schoolClassShouldHaveNameAndGradeLevel() {
        assertEquals("Grade 11B", schoolClass.getName());
        assertEquals(11, schoolClass.getGradeLevel());
    }

    @Test
    void schoolClassShouldAddStudent() {
        schoolClass.addStudent(student1);
        
        assertTrue(schoolClass.getStudents().contains(student1));
    }

    @Test
    void schoolClassShouldSetClassTeacher() {
        schoolClass.setClassTeacher(teacher);
        
        assertEquals(teacher, schoolClass.getClassTeacher());
    }

    @Test
    void schoolClassShouldGetStudentCount() {
        schoolClass.addStudent(student1);
        schoolClass.addStudent(student2);
        
        assertEquals(2, schoolClass.getStudentCount());
    }

    @Test
    void schoolClassShouldNotAddDuplicateStudent() {
        schoolClass.addStudent(student1);
        schoolClass.addStudent(student1);
        
        assertEquals(1, schoolClass.getStudentCount());
    }
}
