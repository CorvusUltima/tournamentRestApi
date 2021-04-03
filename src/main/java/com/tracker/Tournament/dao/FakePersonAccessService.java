package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonAccessService implements  PersonDao{


    private static List<Person> DB =new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person)
    {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {
       return DB.stream()
               .filter(person -> person.getId().equals(id))
               .findFirst();
    }

    @Override
    public int deletePersonByID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }


}
