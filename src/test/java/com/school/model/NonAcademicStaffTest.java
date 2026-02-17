package com.school.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for NonAcademicStaff class
 */
class NonAcademicStaffTest {

    @Test
    void nonAcademicStaffShouldHaveIdNameAgeAndRole() {
        NonAcademicStaff staff = new NonAcademicStaff("NAC001", "John Davis", 35, "Librarian");
        
        assertEquals("NAC001", staff.getId());
        assertEquals("John Davis", staff.getName());
        assertEquals(35, staff.getAge());
        assertEquals("Librarian", staff.getRole());
    }

    @Test
    void nonAcademicStaffShouldPerformDuty() {
        NonAcademicStaff staff = new NonAcademicStaff("NAC002", "Mary Wilson", 42, "Accountant");
        
        assertDoesNotThrow(() -> staff.performDuty());
    }

    @Test
    void nonAcademicStaffShouldExtendStaff() {
        NonAcademicStaff staff = new NonAcademicStaff("NAC003", "Robert Brown", 38, "Cleaner");
        
        assertTrue(staff instanceof Staff);
        assertTrue(staff instanceof Person);
    }
}
