package com.school.model;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Additional tests for Staff edge cases
 */
class StaffEdgeCaseTest {

    @Test
    void staffShouldRejectNullDepartment() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Teacher("TCH001", "John", 30, null);
        });
    }

    @Test
    void staffShouldRejectEmptyDepartment() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Teacher("TCH001", "John", 30, "");
        });
    }

    @Test
    void staffShouldRejectNullDepartmentInSetter() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        assertThrows(IllegalArgumentException.class, () -> {
            teacher.setDepartment(null);
        });
    }

    @Test
    void staffShouldRejectNegativeSalary() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        assertThrows(IllegalArgumentException.class, () -> {
            teacher.setSalary(-1000);
        });
    }

    @Test
    void staffShouldSetSalary() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        teacher.setSalary(50000);
        assertEquals(50000, teacher.getSalary());
    }

    @Test
    void nonAcademicStaffShouldRejectNullRole() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NonAcademicStaff("NAC001", "John", 30, null);
        });
    }

    @Test
    void nonAcademicStaffShouldRejectEmptyRole() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NonAcademicStaff("NAC001", "John", 30, "");
        });
    }

    @Test
    void nonAcademicStaffShouldRejectNullRoleInSetter() {
        NonAcademicStaff staff = new NonAcademicStaff("NAC001", "John", 30, "Librarian");
        assertThrows(IllegalArgumentException.class, () -> {
            staff.setRole(null);
        });
    }

    @Test
    void nonAcademicStaffShouldSetRole() {
        NonAcademicStaff staff = new NonAcademicStaff("NAC001", "John", 30, "Librarian");
        staff.setRole("Accountant");
        assertEquals("Accountant", staff.getRole());
    }

    @Test
    void teacherShouldRejectNullCourse() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        assertThrows(IllegalArgumentException.class, () -> {
            teacher.assignCourse(null);
        });
    }

    @Test
    void teacherShouldRemoveCourse() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        Course course = new Course("MATH101", "Math", "Description");
        teacher.assignCourse(course);
        assertEquals(1, teacher.getAssignedCourses().size());
        
        teacher.removeCourse(course);
        assertEquals(0, teacher.getAssignedCourses().size());
    }

    @Test
    void teacherShouldDefensiveCopyCourses() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        Course course = new Course("MATH101", "Math", "Description");
        teacher.assignCourse(course);
        
        Set<Course> courses = teacher.getAssignedCourses();
        courses.clear();
        
        assertEquals(1, teacher.getAssignedCourses().size());
    }

    @Test
    void teacherCanTeachShouldReturnFalseForNull() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        assertFalse(teacher.canTeach(null));
    }

    @Test
    void teacherCanTeachShouldReturnFalseForUnassignedCourse() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        Course course = new Course("MATH101", "Math", "Description");
        assertFalse(teacher.canTeach(course));
    }

    @Test
    void teacherShouldPrintWhenNoCoursesAssigned() {
        Teacher teacher = new Teacher("TCH001", "John", 30, "Math");
        assertDoesNotThrow(() -> teacher.teach());
    }
}
