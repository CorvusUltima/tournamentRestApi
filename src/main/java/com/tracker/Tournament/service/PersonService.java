package com.tracker.Tournament.service;


import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
        boolean exists=personRepository.existsById(PersonId);
        if(!exists) {
            throw new IllegalStateException("Person with id"
                    +PersonId +" does not exists in DB ");
        }
        personRepository.deleteById(PersonId);
    }
    @Transactional
    public void updatePerson(Long personId, String firstName, String lastName, String email) {

        Person person =personRepository.findById( personId)
                .orElseThrow(()->new IllegalStateException("person with id"+ personId+"does not exist "));

             if(firstName!=null&& firstName.length()>0&&!Objects.equals(person.getFirstName(),firstName))
        {
            person.setFirstName(firstName);
        }

        if(lastName!=null&& lastName.length()>0&&!Objects.equals(person.getLastName(),lastName))
        {
            person.setLastName(lastName);
        }

        if(email!=null&& email.length()>0&&!Objects.equals(person.getEmail(),email))
        {
            Optional<Person>personOptional=personRepository.findPersonByEmail(email);
            if(personOptional.isPresent()){
                throw new IllegalStateException("email take");
        }

            person.setEmail(email);
        }

    }

    public Optional<Person> getPersonById(Long personId) {
        boolean exists= personRepository.existsById(personId);
        if(!exists) {
            throw new IllegalStateException("Person with id"
                    +personId +" does not exists in DB ");
        }

       else return  personRepository.findById(personId);
    }

    public Person getOne(Long personId) {
        return personRepository.getOne( personId);
    }
}
