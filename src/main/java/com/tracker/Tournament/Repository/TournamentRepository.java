package com.tracker.Tournament.Repository;

import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query(
            value = "SELECT * FROM tournament t   WHERE t.name = ?1",
            nativeQuery = true)
    Optional<Tournament> findTournamentByName(String name);

}
