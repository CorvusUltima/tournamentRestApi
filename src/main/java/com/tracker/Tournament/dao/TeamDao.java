package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamDao {


    Optional<Team> selectTeamByName(String name);
    List<Team> selectAllTeams();

    int insertTeamByName(String name );
    int deleteTeamByName(String name );




}
