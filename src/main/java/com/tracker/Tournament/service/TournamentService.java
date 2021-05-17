package com.tracker.Tournament.service;

import com.tracker.Tournament.Repository.TournamentRepository;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    private final TournamentRepository tournamentRepository;


    public List<Tournament> getAllTournaments()
    {
        return tournamentRepository.findAll();
    }


    public void addNewTournament(Tournament tournament) {
        Optional<Tournament> teamOptional= tournamentRepository.findTournamentByName
                (tournament.getName());
        if(teamOptional.isPresent())
        {
            throw new IllegalStateException("name taken");
        }
        tournamentRepository.save(tournament);
    }
    public void deleteTournamentById(Long tournamentId) {
        boolean exists= tournamentRepository.existsById(tournamentId);
        if(!exists) {
            throw new IllegalStateException("Person with id"
                    +tournamentId +" does not exists in DB ");
        }
        tournamentRepository.deleteById(tournamentId);
    }
    @Transactional
    public void updateTournament(Long tournamentId, String name) {

        Tournament tournament = tournamentRepository.findById( tournamentId)
                .orElseThrow(()->new IllegalStateException("tournament with id"+ tournamentId+"does not exist "));

        if(name!=null&& name.length()>0&&!Objects.equals(tournament.getName(),name))
        {
            Optional<Tournament>tournamentOptional= tournamentRepository.findTournamentByName(name);
            if(tournamentOptional.isPresent()){
                throw new IllegalStateException("name taken");
            }

            tournament.setName(name);
        }

    }

    public Optional <Tournament> getTournamentById(Long tournamentId) {
        boolean exists= tournamentRepository.existsById(tournamentId);
        if(!exists) {
            throw new IllegalStateException("Team with id"
                    +tournamentId +" does not exists in DB ");
        }

        else return tournamentRepository.findById(tournamentId);
    }

    public Tournament getOne(Long tournamentId) {
        return tournamentRepository.getOne(tournamentId);
    }

    public Tournament  save(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }


















}
