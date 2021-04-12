package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
      private final String first_name;
      private final String last_name;
      private final String email;



    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("first_name") String first_name,@JsonProperty("last_name") String last_name, @JsonProperty("last_name")String email) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;

    }


    public String getFirst_name()
    {
        return first_name;
    }

    public UUID getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }
}
