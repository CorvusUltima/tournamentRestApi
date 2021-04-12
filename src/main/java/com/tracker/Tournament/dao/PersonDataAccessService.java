package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")

public class PersonDataAccessService implements PersonDao{

    private static List<Person> DB =new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getFirst_name(), person.getLast_name(), person.getEmail()));
        return 1;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonByID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Person selectPersonByFirst_Name(String personFirst_Name) {
        return null;
    }


}
