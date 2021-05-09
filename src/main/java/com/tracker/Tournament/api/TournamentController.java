package com.tracker.Tournament.api;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.model.Tournament;
import com.tracker.Tournament.service.TeamService;
import com.tracker.Tournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path="/tournament")
@RestController
public class TournamentController {


    private final TeamService teamService;
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TeamService teamService,TournamentService tournamentService) {

        this.teamService = teamService;
        this.tournamentService=tournamentService;
    }

    @GetMapping
    public List<Tournament> getAllTournament()
    {
        return tournamentService.getAllTournaments();
    }

    @GetMapping(path="{tournamentId}")
    public Optional<Tournament> getTournamentById(@PathVariable("tournamentId") Long tournamentId)
    {
        return tournamentService.getTournamentById(tournamentId);
    }

    @PostMapping
    public void createNewTournament(@RequestBody Tournament tournament)
    {
        tournamentService.addNewTournament(tournament);
    }

    @DeleteMapping(path="{tournamentId}")
    public void  deleteTournamentById(@PathVariable("tournamentId") Long tournamentId)
    {
        tournamentService.deleteTournamentById(tournamentId);
    }

    @PutMapping(path="{tournamentId}")
    public void updateTournament
            (
                    @PathVariable("tournamentId") Long tournamentId,
                    @RequestParam(required=false) String name){
        tournamentService.updateTournament(tournamentId, name);
    }


    @PutMapping("/{tournamentId}/team/{teamId}")
   Tournament joinTeamInTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long teamId
    )
    {
        Tournament tournament=tournamentService.getTournamentById(tournamentId).get();
       Team team =teamService.getTeamById(teamId).get();
       tournament.joinTournament(team);
        return tournamentService.save(tournament);
    }




}
