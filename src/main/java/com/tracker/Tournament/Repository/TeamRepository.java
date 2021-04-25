package com.tracker.Tournament.Repository;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(
            value = "SELECT * FROM team t   WHERE t.name = ?1",
            nativeQuery = true)
    Optional<Team> findTeamByName(String name);


}
