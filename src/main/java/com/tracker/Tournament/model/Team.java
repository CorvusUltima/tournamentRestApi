package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.SequenceGenerator;

public class Team {



    @SequenceGenerator(
            name="team_sequence" ,
            sequenceName="person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="team_sequence"
    )



   private Long Id ;
    private String name;

    public Team() {
    }

    public Team(@JsonProperty("id")Long id,
                @JsonProperty("name")String name) {
        Id = id;
        this.name = name;
    }

    public Team(  @JsonProperty("name")String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
