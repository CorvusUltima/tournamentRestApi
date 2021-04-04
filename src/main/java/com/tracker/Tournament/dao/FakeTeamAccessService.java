package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeTeamAccessService implements TeamDao{

    private static List<Team> DB_Teams =new ArrayList<>();
    Team team;

    @Override
    public Optional<Team> selectTeamByName(String name) {
         return DB_Teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst();
    }
    @Override
    public List<Team> selectAllTeams() {
     return DB_Teams;
    }

    @Override
    public int insertTeamByName(String teamName) {
        DB_Teams.add(new Team(teamName));
        return 1;
    }
    @Override
    public int deleteTeamByName(String name) {
        Optional<Team>teamMaybe=selectTeamByName(name);
        if (teamMaybe.isEmpty())
        {
            return 0;
        }
        DB_Teams.remove(teamMaybe.get());
        return 1 ;
    }



}
