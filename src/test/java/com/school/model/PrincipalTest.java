package com.school.model;

import com.school.service.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Principal class and administrative functions
 */
class PrincipalTest {
    
    private Principal principal;
    private School school;

    @BeforeEach
    void setUp() {
        principal = new Principal("PRN001", "Dr. Anderson", 50, "Administration");
        school = new School("Springfield High");
    }

    @Test
    void principalShouldAdmitApplicantOfCorrectAge() {
        Applicant applicant = new Applicant("APP001", "Young Student", 12);
        
        Student admitted = principal.admit(applicant, school);
        
        assertNotNull(admitted);
        assertTrue(school.getStudents().contains(admitted));
    }

    @Test
    void principalShouldNotAdmitApplicantTooYoung() {
        Applicant youngApplicant = new Applicant("APP002", "Too Young", 5);
        
        assertThrows(IllegalArgumentException.class, () -> {
            principal.admit(youngApplicant, school);
        });
        assertFalse(school.getStudents().stream()
                .anyMatch(s -> s.getName().equals("Too Young")));
    }

    @Test
    void principalShouldNotAdmitApplicantTooOld() {
        Applicant oldApplicant = new Applicant("APP003", "Too Old", 25);
        
        assertThrows(IllegalArgumentException.class, () -> {
            principal.admit(oldApplicant, school);
        });
    }

    @Test
    void principalShouldExpelStudent() {
        Student student = new Student("STU001", "Troublemaker", 16);
        school.addStudent(student);
        
        principal.expel(student, school);
        
        assertFalse(school.getStudents().contains(student));
    }

    @Test
    void principalCannotExpelNonexistentStudent() {
        Student outsider = new Student("STU999", "Not Enrolled", 15);
        
        assertThrows(IllegalStateException.class, () -> {
            principal.expel(outsider, school);
        });
    }
}
