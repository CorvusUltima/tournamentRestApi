package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping(value= "api/v1/person")
@RestController

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService=personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

   @GetMapping(path="{id}")
    public Person getPersonByID(@PathVariable("id")UUID id)
    {
        return personService.getPersonByID(id)
                .orElse( null);  // good place to add a message to the client,more inf
    }

}
