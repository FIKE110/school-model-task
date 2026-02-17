package com.school.model;

/**
 * Applicant entity who can apply for admission
 */
public class Applicant extends Person {
    private static final int MIN_ADMISSION_AGE = 6;
    private static final int MAX_ADMISSION_AGE = 20;

    public Applicant(String id, String name, int age) {
        super(id, name, age);
    }

    public boolean isEligibleForAdmission() {
        return age >= MIN_ADMISSION_AGE && age <= MAX_ADMISSION_AGE;
    }

    public Student toStudent(String studentId) {
        return new Student(studentId, this.name, this.age);
    }
}
