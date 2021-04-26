package com.tracker.Tournament.service;

import com.tracker.Tournament.Repository.TeamRepository;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TeamService {

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private final TeamRepository teamRepository;

    public List<Team> getAllTeams()
    {
        return teamRepository.findAll();
    }


    public void addNewTeam(Team team) {
        Optional<Team> teamOptional= teamRepository.findTeamByName
               (team.getName());
        if(teamOptional.isPresent())
        {
            throw new IllegalStateException("name taken");
        }
        teamRepository.save(team);
    }
    public void deleteTeamById(Long teamId) {
        boolean exists= teamRepository.existsById(teamId);
        if(!exists) {
            throw new IllegalStateException("Person with id"
                    +teamId +" does not exists in DB ");
        }
        teamRepository.deleteById(teamId);
    }
    @Transactional
    public void updateTeam(Long teamId, String name) {

        Team team = teamRepository.findById( teamId)
                .orElseThrow(()->new IllegalStateException("person with id"+ teamId+"does not exist "));

        if(name!=null&& name.length()>0&&!Objects.equals(team.getName(),name))
        {
            Optional<Team>teamOptional= teamRepository.findTeamByName(name);
            if(teamOptional.isPresent()){
                throw new IllegalStateException("name taken");
            }

            team.setName(name);
        }

    }

    public Optional <Team> getTeamById(Long teamId) {

       return teamRepository.findById(teamId);

    }
}
