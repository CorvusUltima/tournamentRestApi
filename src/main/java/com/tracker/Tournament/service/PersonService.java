package com.tracker.Tournament.service;


import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Person> personOptional=personRepository.
                findPersonByEmail(person.getEmail());
        if(personOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        personRepository.save(person);
    }

    public void deletePersonById(Long PersonId) {
        personRepository.findById(PersonId);
    }
}
