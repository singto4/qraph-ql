package com.example.Spring_GraphQL_Workshop.model;

public record Author(Integer id, String firstName, String lastName) {
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
