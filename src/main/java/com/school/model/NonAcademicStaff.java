package com.school.model;

/**
 * NonAcademicStaff entity for support staff
 */
public class NonAcademicStaff extends Staff {
    private String role;

    public NonAcademicStaff(String id, String name, int age, String role) {
        super(id, name, age, "Administration");
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        this.role = role;
    }

    @Override
    public void performDuty() {
        System.out.println(name + " is performing duties as " + role);
    }
}
