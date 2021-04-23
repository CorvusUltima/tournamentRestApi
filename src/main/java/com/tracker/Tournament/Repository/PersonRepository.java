package com.tracker.Tournament.Repository;

import com.tracker.Tournament.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


@Query(
        value = "SELECT * FROM PERSON p  WHERE p.email = ?1",
        nativeQuery = true)
Optional<Person>findPersonByEmail(String email);



}
