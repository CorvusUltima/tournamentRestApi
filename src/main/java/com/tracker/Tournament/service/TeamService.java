package com.tracker.Tournament.service;

import com.tracker.Tournament.dao.TeamDao;
import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    private final TeamDao teamDao;


    @Autowired
    public TeamService(@Qualifier("fakeTeam")TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public int addTeam(Team team)
    {
        return teamDao.insertTeam(team);
    }

    public List<Team>getAllTeams(){
        return teamDao.selectAllTeams();
    }

    public Optional<Team> getTeamByName(String name){
        return teamDao.selectTeamByName(name);
    }


    public int deleteTeamByName(String  name)
    {
        return teamDao.deleteTeamByName(name);
    }

    public void AddTeamMemberByName(String teamName,String personName)
    {
        teamDao.insertTeamMemberByName(teamName,personName);
    }



}
