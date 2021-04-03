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
        Optional<Person>personMaybe=selectPersonByID(id);
        if (personMaybe.isEmpty())
        {
            return 0;
        }
        DB.remove(personMaybe.get());
                return 1 ;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonByID(id)
                .map(p->{
                  int indexOfPersonToDelete=DB.indexOf(person);

                  if (indexOfPersonToDelete>=0){
                      DB.set(indexOfPersonToDelete,person);
                              return 1;
                    }
                  return 0;
                })
        .orElse(0);
    }


}
