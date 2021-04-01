package service;


import dao.PersonDao;
import model.Person;

import java.util.List;

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
