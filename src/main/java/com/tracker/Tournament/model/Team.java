package com.tracker.Tournament.model;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Team {

    @NotBlank
    private final String name ;


    private List<Person> TeamMember = new ArrayList<>();


    public Team(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getTeamMember() {
        return TeamMember;
    }

}
