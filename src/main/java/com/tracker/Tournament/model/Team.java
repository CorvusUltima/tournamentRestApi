package com.tracker.Tournament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Team   {


    @Id
    @GeneratedValue
    private Long id ;
    private String name;




    @ManyToMany(mappedBy = "teamJoined")
    private List<Person> members;

    public void addPlayer(Person player)
    {
     members.add(player);
    }



    public Team() {
    }




    public Team(@JsonProperty("id")Long id,
                @JsonProperty("name")String name) {
        id = id;
        this.name = name;
    }


    public List<Person> getTeamMembers() {
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
}
