package com.tracker.Tournament.service;


import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

   @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private final PersonRepository personRepository;

    public List<Person> getAllPeople()
    {
        return personRepository.findAll();
    }


    public void addNewPerson(Person person) {
        System.out.println(person);
    }
}
