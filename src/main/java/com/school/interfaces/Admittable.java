package com.school.interfaces;

import com.school.model.Applicant;
import com.school.model.Student;
import com.school.service.School;

/**
 * Interface for actions that can admit applicants to school
 */
public interface Admittable {
    Student admit(Applicant applicant, School school);
}
