package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id ;
    private final String firstName ;
    private final String lastName;
    private final String email;


    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("firstName")  String firstName,
                  @JsonProperty("lastName")String lastName,
                  @JsonProperty("email")String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.email=email;
    }

    public Person(@JsonProperty("firstName")String firstName,
                  @JsonProperty("lastName")String lastName,
                  @JsonProperty("email")String email) {
        this.id=UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }




    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
