package com.tracker.Tournament.api;

import com.tracker.Tournament.Repository.TeamRepository;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
