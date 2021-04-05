package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Team {

    @NotBlank
    private final String name ;

    public List<Person> TeamMembers = new ArrayList<>();


    public Team(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getTeamMembers() {
        return TeamMembers;
    }

}
