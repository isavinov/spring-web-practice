package org.example.domain;

import javax.validation.constraints.NotBlank;

public class Person {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public Person() {

    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}
