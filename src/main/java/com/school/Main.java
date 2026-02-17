package com.school;

import com.school.model.*;
import com.school.service.School;

/**
 * Main entry point demonstrating the School Management System
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SCHOOL MANAGEMENT SYSTEM DEMONSTRATION");
        System.out.println("==========================================\n");

        // Create a new school
        School springfieldHigh = new School("Springfield High School");
        System.out.println("Created: " + springfieldHigh.getName());
        System.out.println();

        // Setup school staff
        setupStaff(springfieldHigh);

        // Setup courses
        setupCourses(springfieldHigh);

        // Setup classes
        setupClasses(springfieldHigh);

        // Process applicants and admit students
        processAdmissions(springfieldHigh);

        // Assign teachers to courses
        assignCourses(springfieldHigh);

        // Enroll students in classes
        enrollStudents(springfieldHigh);

        // Demonstrate teaching
        demonstrateTeaching(springfieldHigh);

        // Show school statistics
        showStatistics(springfieldHigh);

        // Demonstrate expulsion
        demonstrateExpulsion(springfieldHigh);

        // Show final statistics
        System.out.println("\n==========================================");
        System.out.println("   FINAL SCHOOL STATISTICS");
        System.out.println("==========================================");
        showStatistics(springfieldHigh);
    }

    private static void setupStaff(School school) {
        System.out.println("--- Setting Up Staff ---");

        // Principal
        Principal principal = new Principal("PRN001", "Dr. Sarah Anderson", 52, "Administration");
        principal.setSalary(120000);
        school.addStaff(principal);
        System.out.println("✓ Principal: " + principal.getName());

        // Teachers
        Teacher mathTeacher = new Teacher("TCH001", "Mr. Robert Johnson", 45, "Mathematics");
        mathTeacher.setSalary(65000);
        school.addStaff(mathTeacher);
        System.out.println("✓ Teacher: " + mathTeacher.getName() + " (" + mathTeacher.getDepartment() + ")");

        Teacher scienceTeacher = new Teacher("TCH002", "Ms. Emily Chen", 38, "Science");
        scienceTeacher.setSalary(68000);
        school.addStaff(scienceTeacher);
        System.out.println("✓ Teacher: " + scienceTeacher.getName() + " (" + scienceTeacher.getDepartment() + ")");

        Teacher englishTeacher = new Teacher("TCH003", "Mrs. Patricia Williams", 42, "English");
        englishTeacher.setSalary(62000);
        school.addStaff(englishTeacher);
        System.out.println("✓ Teacher: " + englishTeacher.getName() + " (" + englishTeacher.getDepartment() + ")");

        // Non-academic staff
        NonAcademicStaff librarian = new NonAcademicStaff("NAC001", "James Wilson", 35, "Librarian");
        librarian.setSalary(40000);
        school.addStaff(librarian);
        System.out.println("✓ Staff: " + librarian.getName() + " (" + librarian.getRole() + ")");

        NonAcademicStaff accountant = new NonAcademicStaff("NAC002", "Maria Garcia", 41, "Accountant");
        accountant.setSalary(55000);
        school.addStaff(accountant);
        System.out.println("✓ Staff: " + accountant.getName() + " (" + accountant.getRole() + ")");

        System.out.println();
    }

    private static void setupCourses(School school) {
        System.out.println("--- Setting Up Courses ---");

        Course algebra = new Course("MAT101", "Algebra I", "Introduction to algebraic concepts");
        school.addCourse(algebra);
        System.out.println("✓ Course: " + algebra.getName());

        Course geometry = new Course("MAT102", "Geometry", "Study of shapes and spatial relationships");
        school.addCourse(geometry);
        System.out.println("✓ Course: " + geometry.getName());

        Course biology = new Course("SCI101", "Biology", "Study of living organisms");
        school.addCourse(biology);
        System.out.println("✓ Course: " + biology.getName());

        Course chemistry = new Course("SCI102", "Chemistry", "Study of matter and its properties");
        school.addCourse(chemistry);
        System.out.println("✓ Course: " + chemistry.getName());

        Course literature = new Course("ENG101", "English Literature", "Study of classic and modern literature");
        school.addCourse(literature);
        System.out.println("✓ Course: " + literature.getName());

        Course composition = new Course("ENG102", "Composition", "Writing and communication skills");
        school.addCourse(composition);
        System.out.println("✓ Course: " + composition.getName());

        System.out.println();
    }

    private static void setupClasses(School school) {
        System.out.println("--- Setting Up Classes ---");

        SchoolClass grade9A = new SchoolClass("Grade 9A", 9);
        school.addClass(grade9A);
        System.out.println("✓ Class: " + grade9A.getName());

        SchoolClass grade9B = new SchoolClass("Grade 9B", 9);
        school.addClass(grade9B);
        System.out.println("✓ Class: " + grade9B.getName());

        SchoolClass grade10A = new SchoolClass("Grade 10A", 10);
        school.addClass(grade10A);
        System.out.println("✓ Class: " + grade10A.getName());

        System.out.println();
    }

    private static void processAdmissions(School school) {
        System.out.println("--- Processing Admissions ---");

        Principal principal = school.getPrincipal();

        // Successful admissions
        Applicant[] successfulApplicants = {
            new Applicant("APP001", "Alice Johnson", 14),
            new Applicant("APP002", "Bob Smith", 15),
            new Applicant("APP003", "Charlie Brown", 14),
            new Applicant("APP004", "Diana Prince", 16),
            new Applicant("APP005", "Eve Davis", 15),
            new Applicant("APP006", "Frank Miller", 14)
        };

        for (Applicant applicant : successfulApplicants) {
            try {
                Student student = principal.admit(applicant, school);
                System.out.println("✓ Admitted: " + applicant.getName() + " (Age: " + applicant.getAge() + 
                    ") -> Student ID: " + student.getId());
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Rejected: " + applicant.getName() + " - " + e.getMessage());
            }
        }

        // Failed admission (too young)
        System.out.println("\n--- Testing Age Restrictions ---");
        Applicant tooYoung = new Applicant("APP007", "Young Kid", 5);
        try {
            principal.admit(tooYoung, school);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly rejected: " + tooYoung.getName() + " (Age: " + tooYoung.getAge() + 
                ") - " + e.getMessage());
        }

        // Failed admission (too old)
        Applicant tooOld = new Applicant("APP008", "Old Student", 25);
        try {
            principal.admit(tooOld, school);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly rejected: " + tooOld.getName() + " (Age: " + tooOld.getAge() + 
                ") - " + e.getMessage());
        }

        System.out.println();
    }

    private static void assignCourses(School school) {
        System.out.println("--- Assigning Courses to Teachers ---");

        for (Staff staff : school.getStaff()) {
            if (staff instanceof Teacher) {
                Teacher teacher = (Teacher) staff;

                if (teacher.getDepartment().equals("Mathematics")) {
                    Course algebra = findCourse(school, "MAT101");
                    Course geometry = findCourse(school, "MAT102");
                    if (algebra != null) teacher.assignCourse(algebra);
                    if (geometry != null) teacher.assignCourse(geometry);
                    System.out.println("✓ " + teacher.getName() + " assigned to: Algebra I, Geometry");
                } else if (teacher.getDepartment().equals("Science")) {
                    Course biology = findCourse(school, "SCI101");
                    Course chemistry = findCourse(school, "SCI102");
                    if (biology != null) teacher.assignCourse(biology);
                    if (chemistry != null) teacher.assignCourse(chemistry);
                    System.out.println("✓ " + teacher.getName() + " assigned to: Biology, Chemistry");
                } else if (teacher.getDepartment().equals("English")) {
                    Course literature = findCourse(school, "ENG101");
                    Course composition = findCourse(school, "ENG102");
                    if (literature != null) teacher.assignCourse(literature);
                    if (composition != null) teacher.assignCourse(composition);
                    System.out.println("✓ " + teacher.getName() + " assigned to: English Literature, Composition");
                }
            }
        }

        System.out.println();
    }

    private static void enrollStudents(School school) {
        System.out.println("--- Enrolling Students in Classes ---");

        // Get teachers and classes
        Teacher mathTeacher = null;
        Teacher scienceTeacher = null;

        for (Staff staff : school.getStaff()) {
            if (staff instanceof Teacher) {
                Teacher teacher = (Teacher) staff;
                if (teacher.getDepartment().equals("Mathematics")) {
                    mathTeacher = teacher;
                } else if (teacher.getDepartment().equals("Science")) {
                    scienceTeacher = teacher;
                }
            }
        }

        SchoolClass grade9A = findClass(school, "Grade 9A");
        SchoolClass grade9B = findClass(school, "Grade 9B");
        SchoolClass grade10A = findClass(school, "Grade 10A");

        // Assign teachers to classes
        if (mathTeacher != null && grade9A != null) {
            school.assignTeacherToClass(mathTeacher, grade9A);
            System.out.println("✓ " + mathTeacher.getName() + " assigned as teacher for " + grade9A.getName());
        }

        if (scienceTeacher != null && grade9B != null) {
            school.assignTeacherToClass(scienceTeacher, grade9B);
            System.out.println("✓ " + scienceTeacher.getName() + " assigned as teacher for " + grade9B.getName());
        }

        // Enroll students
        int studentCount = 0;
        for (Student student : school.getStudents()) {
            SchoolClass targetClass;
            if (studentCount < 2) {
                targetClass = grade9A;
            } else if (studentCount < 4) {
                targetClass = grade9B;
            } else {
                targetClass = grade10A;
            }

            if (targetClass != null) {
                school.enrollStudentInClass(student, targetClass);
                System.out.println("✓ " + student.getName() + " enrolled in " + targetClass.getName());
            }
            studentCount++;
        }

        System.out.println();
    }

    private static void demonstrateTeaching(School school) {
        System.out.println("--- Teachers Performing Duties ---");

        for (Staff staff : school.getStaff()) {
            System.out.println();
            staff.performDuty();
        }

        System.out.println();
    }

    private static void demonstrateExpulsion(School school) {
        System.out.println("--- Demonstrating Expulsion Process ---");

        Principal principal = school.getPrincipal();
        Student studentToExpel = findStudent(school, "STU005");

        if (studentToExpel != null && principal != null) {
            System.out.println("Student to expel: " + studentToExpel.getName() + " (ID: " + studentToExpel.getId() + ")");
            principal.expel(studentToExpel, school);
            System.out.println();

            // Try to expel same student again (should fail)
            System.out.println("--- Attempting to Expel Non-existent Student ---");
            try {
                principal.expel(studentToExpel, school);
            } catch (IllegalStateException e) {
                System.out.println("✓ Correctly prevented: " + e.getMessage());
            }
        }

        System.out.println();
    }

    private static void showStatistics(School school) {
        System.out.println("School Statistics:");
        System.out.println("  Total Students: " + school.getStudentCount());
        System.out.println("  Total Staff: " + school.getStaffCount());
        System.out.println("  Total Courses: " + school.getCourseCount());
        System.out.println("  Total Classes: " + school.getClassCount());

        Principal principal = school.getPrincipal();
        if (principal != null) {
            System.out.println("  Principal: " + principal.getName());
        }

        // Show class details
        System.out.println("\nClass Details:");
        for (SchoolClass schoolClass : school.getClasses()) {
            System.out.println("  " + schoolClass.getName() + ":");
            System.out.println("    Students: " + schoolClass.getStudentCount());
            if (schoolClass.getClassTeacher() != null) {
                System.out.println("    Teacher: " + schoolClass.getClassTeacher().getName());
            }
        }
    }

    // Helper methods
    private static Course findCourse(School school, String code) {
        for (Course course : school.getCourses()) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static SchoolClass findClass(School school, String name) {
        for (SchoolClass schoolClass : school.getClasses()) {
            if (schoolClass.getName().equals(name)) {
                return schoolClass;
            }
        }
        return null;
    }

    private static Student findStudent(School school, String id) {
        for (Student student : school.getStudents()) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
