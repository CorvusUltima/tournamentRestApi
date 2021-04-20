package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        DB.add(new Person(id,person.getFirst_name(), person.getLast_name(), person.getEmail()));
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

    public Person  selectPersonByFirst_Name(String personFirst_Name)
    {
        int PersonNumber=0;
        for (int i = 0; i < DB.size(); i++)
        {
            if (DB.get(i).getFirst_name().equals(personFirst_Name)) {
                PersonNumber=i;
                break;
            }

        }
        return DB.get(PersonNumber);
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
    public int updatePersonById(UUID id, Person personUpdate) {
        return selectPersonByID(id)
                .map(person->{
                  int indexOfPersonToUpdate=DB.indexOf(person);

                  if (indexOfPersonToUpdate>=0){
                      DB.set(indexOfPersonToUpdate,new Person(id,personUpdate.getFirst_name(),personUpdate.getLast_name(),personUpdate.getEmail()));
                              return 1;
                    }
                  return 0;
                })
        .orElse(0);
    }


}
