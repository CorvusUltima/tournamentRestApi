package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamDao {


    Optional<Team> selectTeamByName(String name);
    List<Team> selectAllTeams();

    int insertTeam(Team team );
    int deleteTeamByName(String name );
    int insertTeamMemberByName(String teamName,  String personName);



}
