package com.tracker.Tournament.api;


import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RequestMapping(path="api/v1/team")
@RestController
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
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






}
