package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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
    public void addPerson(@Valid @RequestBody Person person)
    {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }


   /*  @GetMapping(path="{id}")
    public Person getPersonByID(@PathVariable("id")UUID id)
    {
        return personService.getPersonByID(id)
                .orElse( null);  // good place to add a message to the client,more inf
    }

    */

    @GetMapping(path="{name}")
   public Person selectPersonByName(@PathVariable("name") String name)
    {
        return personService.selectPersonByName(name);
    }


    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id")UUID id)
    {
        personService.deletePerson(id);
    }


    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id")UUID id ,@Valid @NonNull @RequestBody Person personToUpdate)
    {
        personService.updatePerson(id,personToUpdate);
    }



}
