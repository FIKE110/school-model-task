package com.school.model;

import com.school.service.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for Principal edge cases
 */
class PrincipalEdgeCaseTest {

    private Principal principal;
    private School school;

    @BeforeEach
    void setUp() {
        principal = new Principal("PRN001", "Dr. Smith", 50, "Admin");
        school = new School("Test School");
    }

    @Test
    void principalShouldRejectNullApplicant() {
        assertThrows(IllegalArgumentException.class, () -> {
            principal.admit(null, school);
        });
    }

    @Test
    void principalShouldRejectNullSchoolOnAdmit() {
        Applicant applicant = new Applicant("APP001", "John", 15);
        assertThrows(IllegalArgumentException.class, () -> {
            principal.admit(applicant, null);
        });
    }

    @Test
    void principalShouldRejectNullStudentOnExpel() {
        assertThrows(IllegalArgumentException.class, () -> {
            principal.expel(null, school);
        });
    }

    @Test
    void principalShouldRejectNullSchoolOnExpel() {
        Student student = new Student("STU001", "John", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            principal.expel(student, null);
        });
    }

    @Test
    void principalShouldPerformDuty() {
        assertDoesNotThrow(() -> principal.performDuty());
    }

    @Test
    void principalShouldSetDepartment() {
        principal.setDepartment("Administration");
        assertEquals("Administration", principal.getDepartment());
    }

    @Test
    void principalShouldSetSalary() {
        principal.setSalary(100000);
        assertEquals(100000, principal.getSalary());
    }
}
