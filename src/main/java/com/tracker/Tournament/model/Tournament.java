package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Tournament {

    @Id
    @GeneratedValue
    private Long id ;
    private String name;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "teams_joined",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> enteredTeams = new HashSet<>();




    public Tournament(@JsonProperty("id")Long id, @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }

    public Tournament(@JsonProperty("name")String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getEnteredTeams() {
        return enteredTeams;
    }

    public void setEnteredTeams(Set<Team> enteredTeams) {
        this.enteredTeams = enteredTeams;
    }

    void joinTournament(Team team)
    {
        enteredTeams.add(team);
    }
}
