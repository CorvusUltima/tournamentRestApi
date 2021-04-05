package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeTeam")

public class FakeTeamAccessService implements TeamDao{

    private static List<Team> DB_Teams =new ArrayList<>();
    Team team;
    FakePersonAccessService fakePersonAccessService;

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
    public int insertTeam(Team team) {
        DB_Teams.add(new Team(team.getName()));
        return 1;
    }

    public Team getTeamByName(String teamName) {
        for (int i = 0; i < DB_Teams.size(); i++) {
            if (DB_Teams.get(i).getName().equals(teamName)) {
                return DB_Teams.get(i);
            }

        }
        return null;
    }



    public int insertTeamMemberById(String teamName,Person person,UUID id)
    {

        Optional<Person>personMaybe=fakePersonAccessService.selectPersonByID(id);
        if (personMaybe.isEmpty())
        {
            return 0;
        }
        getTeamByName(teamName).TeamMembers.add(personMaybe.get());
        return 1 ;
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
