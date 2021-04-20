package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonDao {


    int insertPerson(UUID id , Person person);

    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonByID(UUID id);

    int deletePersonByID(UUID id );
    int updatePersonById(UUID id ,Person person);
    Person selectPersonByFirst_Name(String personFirst_Name);

}
