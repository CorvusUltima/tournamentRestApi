package com.tracker.Tournament.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.PersonService;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RequestMapping(path="/team")
@RestController
public class TeamController {

    private final TeamService teamService;
    private final PersonService personService;

    @Autowired
    public TeamController(TeamService teamService,PersonService personService) {

        this.teamService = teamService;
        this.personService=personService;
    }

    @GetMapping
    public List<Team> getAllTeams()
    {
        return teamService.getAllTeams();
    }

    @GetMapping(path="{teamId}")
    public Optional<Team> getTeamById(@PathVariable("teamId") Long teamId)
    {
        return teamService.getTeamById(teamId);
    }

    @PostMapping
    public void registerNewTeam(@RequestBody Team team)
    {
        teamService.addNewTeam(team);
    }

    @DeleteMapping(path="{teamId}")
    public void  deleteTeamById(@PathVariable("personId") Long teamId)
    {
        teamService.deleteTeamById(teamId);
    }

    @PutMapping(path="{teamId}")
    public void updateTeam
            (
            @PathVariable("teamId") Long teamId,
            @RequestParam(required=false) String name){
            teamService.updateTeam(teamId, name);
    }


    @PutMapping("/{teamId}/person/{personId}")
        Team joinMemberInTeam(
           @PathVariable Long teamId,
           @PathVariable Long personId
    )
    {
        Team team=teamService.getTeamById(teamId).get();
        Person person = personService.getPersonById(personId).get();
        team.addTeamMember(person);
        return teamService.save(team);
    }






}
