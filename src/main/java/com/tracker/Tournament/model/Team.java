package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Team   {


    @Id
    @GeneratedValue
    private Long id ;
    private String name;



    @ManyToMany
    @JoinTable(
            name = "players_joined",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> members  = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "enteredTeams")
    private Set<Tournament> tournamentJoined = new HashSet<>();


    public void addPlayer(Person player)
    {
     members.add(player);
    }

    public Team() {
    }

    public Team(@JsonProperty("id")Long id,
                @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }


    public Set<Person> getTeamMembers() {
        return members;
    }

    public Team(@JsonProperty("name")String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeamMember(Person person) {

        members.add(person);
    }
}
