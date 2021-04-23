package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tracker.Tournament.service.PersonService;

import java.util.List;

import static com.sun.beans.introspect.PropertyInfo.Name.required;


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

    @PostMapping
    public void registerNewPerson(@RequestBody Person person)
    {
        personService.addNewPerson(person);
    }

    @DeleteMapping(path="{personId}")
    public void  deletePersonById(@PathVariable("personId") Long personId)
    {
        personService.deletePersonById(personId);
    }
    @PutMapping(path="{personId}")
    public void updatePerson(
          @PathVariable("personID")   Long personId,
          @RequestParam(required=false) String firstName,
          @RequestParam(required=false) String lastName,
          @RequestParam(required=false) String email){
        personService.updatePerson(personId,firstName,lastName,email);
    }






}
