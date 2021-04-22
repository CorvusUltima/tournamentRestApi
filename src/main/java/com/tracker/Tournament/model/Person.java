package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name="person_sequence" ,
            sequenceName="person_sequence",
            allocationSize = 1
            )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="person_sequence"
    )



    private Long id ;
    private  String firstName ;
    private  String lastName;
    private  String email;


    public Person() {

    }

    public Person(@JsonProperty("id") Long id,
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

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
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
