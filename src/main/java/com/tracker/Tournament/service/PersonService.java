package com.tracker.Tournament.service;


import com.tracker.Tournament.dao.PersonDao;
import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

private final PersonDao personDao;

@Autowired
public PersonService (@Qualifier("fakeDao") PersonDao personDao)
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


  public Optional<Person> getPersonByID(UUID id){
    return personDao.selectPersonByID(id);
  }

  public Person selectPersonByName(String personFirst_name)
  {
      return personDao.selectPersonByFirst_Name( personFirst_name);
  }

  public int deletePerson(UUID id){
  return personDao.deletePersonByID(id);
  }
  public int updatePerson(UUID id,Person newPerson ) {
      return personDao.updatePersonById(id,newPerson);
  }

}
