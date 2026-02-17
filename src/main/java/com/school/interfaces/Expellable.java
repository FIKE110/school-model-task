package com.school.interfaces;

import com.school.model.Student;
import com.school.service.School;

/**
 * Interface for actions that can expel students
 */
public interface Expellable {
    void expel(Student student, School school);
}
