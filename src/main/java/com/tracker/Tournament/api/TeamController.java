package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(value= "api/v1/team")
@RestController

public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;

    }

    @PostMapping
    public void addTeam(@RequestBody Team team)
    {
       teamService.addTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping(path="{name}")
    public Team getTeamByName(@PathVariable("name") String name)
    {
        return teamService.getTeamByName(name)
                .orElse( null);  // good place to add a message to the client,more inf
    }

    @DeleteMapping(path="{name}")
    public void deleteTeamByName(@PathVariable("name")String name)
    {
         teamService.deleteTeamByName(name);
    }

    @PutMapping(path= {"{name}", "{id}"})
    public void addTeamMemberByName(@PathVariable("name")String teamName,@PathVariable("id")UUID id ,@RequestBody Person personToAdd)
    {
        teamService.AddTeamMemberById(teamName,personToAdd,id);
    }


}
