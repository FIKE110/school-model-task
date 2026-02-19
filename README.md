# School Management System

A Java-based school management system demonstrating Object-Oriented Programming (OOP) principles including abstraction, encapsulation, inheritance, and polymorphism.

## Project Overview

This project models a school system with various actors:
- **Staffs**: Principal, Teachers, and Non-Academic Staff
- **Students**: Enrolled pupils who take courses
- **Applicants**: Potential students applying for admission
- **Courses**: Academic subjects offered by the school
- **Classes**: Grade-level groups with enrolled students

## OOP Concepts Demonstrated

### 1. Abstraction
- Abstract base classes (`Person`, `Staff`) define common behavior
- Interfaces (`Teachable`, `TeachingStaff`, `Admittable`, `Expellable`) provide contracts
- Implementation details hidden behind clean APIs

### 2. Encapsulation
- Private fields with public getters/setters
- Validation in setters to maintain data integrity
- Immutable IDs using `final` modifier
- Defensive copying of collections

### 3. Inheritance
- `Person` ← `Student`, `Applicant`
- `Person` ← `Staff` ← `Teacher`, `Principal`, `NonAcademicStaff`
- Code reuse through hierarchical design

### 4. Polymorphism
- Interface implementations: `Principal` implements `Admittable`, `Expellable`
- `Teacher` implements `TeachingStaff`
- Method overriding: `performDuty()` behaves differently per staff type
- `Course` implements `Teachable`

### 5. Single Responsibility Principle
- Each class has one reason to change
- `School` manages entities, `Principal` handles admissions, `Teacher` focuses on courses
- Separation of concerns across packages

### 6. Composition & Aggregation
- `School` **composes** collections of students, staff, courses, and classes
- `SchoolClass` **aggregates** students and has a class teacher
- `Student` **has** courses (aggregation)

## Project Structure

```
src/
├── main/java/com/school/
│   ├── interfaces/          # Contracts and abstractions
│   │   ├── Teachable.java   # Can be taught (courses)
│   │   ├── TeachingStaff.java  # Can teach courses
│   │   ├── Admittable.java  # Can admit applicants
│   │   └── Expellable.java  # Can expel students
│   ├── model/               # Domain entities
│   │   ├── Person.java      # Abstract: id, name, age
│   │   ├── Student.java     # Takes courses
│   │   ├── Applicant.java   # Applies for admission
│   │   ├── Staff.java       # Abstract: department, salary
│   │   ├── Teacher.java     # Implements TeachingStaff
│   │   ├── Principal.java   # Implements Admittable, Expellable
│   │   ├── NonAcademicStaff.java
│   │   ├── Course.java      # Implements Teachable
│   │   └── SchoolClass.java # Grade/class with students
│   └── service/
│       └── School.java      # Central management service
└── test/java/com/school/
    ├── model/               # Unit tests for entities
    └── service/             # Tests for School service
```

## Key Features

### Principal
- Admit applicants based on age eligibility (6-20 years)
- Expel students from the school
- Manage overall school operations

### Teacher
- Assign courses to teach
- Check if can teach specific courses
- Perform teaching duties

### Student
- Take courses
- Enroll in classes
- Track academic progress

### Applicant
- Check admission eligibility
- Convert to Student upon admission

### School Management
- Add/remove students, staff, courses, and classes
- Assign teachers to classes
- Enroll students in classes
- Track counts and statistics

## Running the Project

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build and Test
```bash
# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Run with verbose output
mvn test -X

# Generate coverage report (view at target/site/jacoco/index.html)
mvn clean test
```

### Run the Demonstration
```bash
# Run the Main class demonstration
mvn compile exec:java -Dexec.mainClass="com.school.Main"

# Or package and run
mvn clean package
java -cp target/week1-task-school-1.0-SNAPSHOT.jar com.school.Main
```

The demonstration will:
1. Create a school with staff (Principal, Teachers, Non-Academic Staff)
2. Set up courses (Math, Science, English)
3. Create grade-level classes
4. Process student admissions with age validation
5. Assign teachers to courses and classes
6. Enroll students in classes
7. Show teachers performing duties
8. Demonstrate student expulsion
9. Display school statistics

### Test Results
```
Tests run: 131, Failures: 0, Errors: 0, Skipped: 0
Code Coverage: 95%
```

All tests pass, covering:
- Entity creation and validation
- Business logic (admission age requirements)
- Staff operations (teaching, managing)
- School management workflows

## Design Decisions

1. **Interfaces for Behavior**: Used interfaces to define what classes can do, not what they are
2. **Abstract Classes for Shared State**: `Person` and `Staff` hold common attributes
3. **Validation**: All setters validate input to prevent invalid states
4. **Collections**: Used `HashSet` for uniqueness and O(1) lookups
5. **Final Fields**: IDs are immutable to prevent identity changes
6. **Package Structure**: Clear separation between model, service, and interfaces

## Code Quality

- **Visibility**: Appropriate use of `public`, `protected`, `private`
- **Immutability**: `final` for IDs and constants
- **Validation**: Input validation in constructors and setters
- **Documentation**: Single-line comments on classes and methods
- **Testing**: TDD approach with 131 comprehensive tests

## Example Usage

```java
// Create a school
School school = new School("Springfield High");

// Add a principal
Principal principal = new Principal("PRN001", "Dr. Smith", 50, "Administration");
school.addStaff(principal);

// Admit an applicant
Applicant applicant = new Applicant("APP001", "Jane Doe", 15);
Student student = principal.admit(applicant, school);

// Add a teacher and course
Teacher teacher = new Teacher("TCH001", "Mr. Johnson", 40, "Mathematics");
school.addStaff(teacher);
Course math = new Course("MATH101", "Mathematics", "Algebra and Geometry");
school.addCourse(math);
teacher.assignCourse(math);

// Create a class and enroll student
SchoolClass grade10 = new SchoolClass("Grade 10A", 10);
school.addClass(grade10);
school.assignTeacherToClass(teacher, grade10);
school.enrollStudentInClass(student, grade10);

// Student takes a course
student.takeCourse(math);
```


---

Built with Maven, tested with JUnit 5, designed with OOP principles.
