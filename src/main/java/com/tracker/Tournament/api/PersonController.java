package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tracker.Tournament.service.PersonService;

import java.util.List;


@RequestMapping(path="api/v1/person")
@RestController

public class PersonController {

    private final PersonService personService ;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPeople()
    {
       return personService.getAllPeople();
    }



}
