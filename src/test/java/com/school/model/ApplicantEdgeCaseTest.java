package com.school.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for Applicant edge cases
 */
class ApplicantEdgeCaseTest {

    @Test
    void applicantShouldBeEligibleAtMinimumAge() {
        Applicant applicant = new Applicant("APP001", "John", 6);
        assertTrue(applicant.isEligibleForAdmission());
    }

    @Test
    void applicantShouldBeEligibleAtMaximumAge() {
        Applicant applicant = new Applicant("APP001", "John", 20);
        assertTrue(applicant.isEligibleForAdmission());
    }

    @Test
    void applicantShouldNotBeEligibleBelowMinimum() {
        Applicant applicant = new Applicant("APP001", "John", 5);
        assertFalse(applicant.isEligibleForAdmission());
    }

    @Test
    void applicantShouldNotBeEligibleAboveMaximum() {
        Applicant applicant = new Applicant("APP001", "John", 21);
        assertFalse(applicant.isEligibleForAdmission());
    }

    @Test
    void applicantToStudentShouldPreserveAge() {
        Applicant applicant = new Applicant("APP001", "John", 15);
        Student student = applicant.toStudent("STU001");
        assertEquals(15, student.getAge());
    }

    @Test
    void applicantToStudentShouldPreserveName() {
        Applicant applicant = new Applicant("APP001", "John Doe", 15);
        Student student = applicant.toStudent("STU001");
        assertEquals("John Doe", student.getName());
    }

    @Test
    void applicantShouldSetName() {
        Applicant applicant = new Applicant("APP001", "John", 15);
        applicant.setName("Jane");
        assertEquals("Jane", applicant.getName());
    }

    @Test
    void applicantShouldSetAge() {
        Applicant applicant = new Applicant("APP001", "John", 15);
        applicant.setAge(16);
        assertEquals(16, applicant.getAge());
    }
}
