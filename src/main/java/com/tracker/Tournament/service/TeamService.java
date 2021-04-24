package com.tracker.Tournament.service;

import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.Repository.TeamRepository;
import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams()
    {
        return teamRepository.findAll();
    }


    public void addNewPerson(Team team) {
        Optional<Team> teamOptional=teamRepository.
                findTeamByName(team.getName());
        if(teamOptional.isPresent())
        {
            throw new IllegalStateException("name taken");
        }
       teamRepository.save(team);
    }
    public void deleteTeamById(Long teamId) {
        boolean exists=teamRepository.existsById(teamId);
        if(!exists) {
            throw new IllegalStateException("Team with id"
                    +teamId +" does not exists in DB ");
        }
       teamRepository.deleteById(teamId);
    }
    @Transactional
    public void updatePerson(Long teamId, String name, String lastName, String email) {

        Team team =teamRepository.findById( teamId)
                .orElseThrow(()->new IllegalStateException("person with id"+ teamId+"does not exist "));

        if(name!=null&& name.length()>0&&!Objects.equals(team.getName(),name))
        {
           team.setName(name);
        }


    }








}
