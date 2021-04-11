package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table

public class Person {
    @Id
    @SequenceGenerator(
            name="person_sequence",
            sequenceName ="person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE ,
            generator="person_sequence"
    )

    private final UUID id ;
    @NotBlank
    private final String name ;



    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name")  String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
