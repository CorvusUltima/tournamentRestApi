package com.tracker.Tournament.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
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
    private LocalDate dob;
    @Transient
    private  Integer age;


    public Person() {

    }

    public Person(  @JsonProperty("id")Long id,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName")String lastName,
                   @JsonProperty("email")String email,
                   @JsonProperty("dob") LocalDate dob)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.email=email;
        this.dob=dob;
    }

    public Person(@JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName")String lastName,
                  @JsonProperty("email") String email,
                  @JsonProperty("dob") LocalDate dob) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob=dob;
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

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge()
    {
        return Period.between(this.dob,LocalDate.now()).getYears();
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
