package com.school.model;

import com.school.interfaces.Admittable;
import com.school.interfaces.Expellable;
import com.school.service.School;

/**
 * Principal entity who can admit applicants and expel students
 */
public class Principal extends Staff implements Admittable, Expellable {

    public Principal(String id, String name, int age, String department) {
        super(id, name, age, department);
    }

    @Override
    public Student admit(Applicant applicant, School school) {
        if (applicant == null) {
            throw new IllegalArgumentException("Applicant cannot be null");
        }
        if (school == null) {
            throw new IllegalArgumentException("School cannot be null");
        }
        if (!applicant.isEligibleForAdmission()) {
            throw new IllegalArgumentException(
                    String.format("Applicant %s is not eligible for admission (age: %d)",
                            applicant.getName(), applicant.getAge()));
        }

        String studentId = generateStudentId(school);
        Student student = applicant.toStudent(studentId);
        school.addStudent(student);

        System.out.println(String.format("Principal %s admitted %s as student %s",
                name, applicant.getName(), studentId));

        return student;
    }

    @Override
    public void expel(Student student, School school) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (school == null) {
            throw new IllegalArgumentException("School cannot be null");
        }
        if (!school.getStudents().contains(student)) {
            throw new IllegalStateException(
                    String.format("Student %s is not enrolled in this school", student.getName()));
        }

        school.removeStudent(student);
        System.out.println(String.format("Principal %s expelled student %s",
                name, student.getName()));
    }

    private String generateStudentId(School school) {
        return String.format("STU%03d", school.getStudentCount() + 1);
    }

    @Override
    public void performDuty() {
        System.out.println(name + " is managing the school");
    }
}
