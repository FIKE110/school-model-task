package com.school.model;

import com.school.service.School;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Applicant class
 */
class ApplicantTest {

    @Test
    void applicantShouldHaveIdNameAndAge() {
        Applicant applicant = new Applicant("APP001", "Sarah Connor", 13);
        
        assertEquals("APP001", applicant.getId());
        assertEquals("Sarah Connor", applicant.getName());
        assertEquals(13, applicant.getAge());
    }

    @Test
    void applicantShouldBeConvertibleToStudent() {
        Applicant applicant = new Applicant("APP002", "John Connor", 14);
        
        Student student = applicant.toStudent("STU999");
        
        assertNotNull(student);
        assertEquals("John Connor", student.getName());
        assertEquals(14, student.getAge());
        assertEquals("STU999", student.getId());
    }

    @Test
    void applicantShouldExtendPerson() {
        Applicant applicant = new Applicant("APP003", "Kyle Reese", 15);
        
        assertTrue(applicant instanceof Person);
    }

    @Test
    void applicantShouldBeEligibleForAdmission() {
        Applicant eligibleApplicant = new Applicant("APP004", "Good Age", 12);
        Applicant tooYoung = new Applicant("APP005", "Too Young", 4);
        Applicant tooOld = new Applicant("APP006", "Too Old", 22);
        
        assertTrue(eligibleApplicant.isEligibleForAdmission());
        assertFalse(tooYoung.isEligibleForAdmission());
        assertFalse(tooOld.isEligibleForAdmission());
    }
}
