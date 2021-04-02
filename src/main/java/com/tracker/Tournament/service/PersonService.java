package com.tracker.Tournament.service;


import com.tracker.Tournament.dao.PersonDao;
import com.tracker.Tournament.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService {

private final PersonDao personDao;

public PersonService(PersonDao personDao)
{
    this.personDao=personDao;
}

    public int addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }

  public List<Person>getAllPeople(){

    return personDao.selectAllPeople();
  }


}
