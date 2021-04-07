package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.PersonService;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value= "api/v1/team")
@RestController

public class TeamController {

    private final TeamService teamService;
    private final PersonService personService;

    @Autowired
    public TeamController(TeamService teamService, PersonService personService) {
        this.teamService = teamService;
        this.personService = personService;
    }

    @PostMapping
    public void addTeam(@Valid @NonNull @RequestBody Team team)
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


    @PutMapping(value="/{teamName}/{personName}")
    public void addTeamMemberByName(@PathVariable String teamName, @PathVariable String personName )
    {
        teamService.AddTeamMemberByName(teamName,personName);
    }

}
