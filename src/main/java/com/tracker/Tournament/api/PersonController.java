package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tracker.Tournament.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RequestMapping(path="/person")
@RestController

public class PersonController {

    private final PersonService personService ;
    private TeamService teamService;

    @Autowired
    public PersonController(PersonService personService, TeamService teamService) {
        this.personService = personService;
        this.teamService = teamService;
    }


    @GetMapping
    public List<Person> getAllPeople()
    {
       return personService.getAllPeople();
    }

    @GetMapping(path="{personId}")
    public Optional<Person> getPersonById(@PathVariable("personId") Long personId)
    {
        return personService.getPersonById(personId);
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
          @PathVariable("personId")   Long personId,
          @RequestParam(required=false) String firstName,
          @RequestParam(required=false) String lastName,
          @RequestParam(required=false) String email){
        personService.updatePerson(personId,firstName,lastName,email);
   }


}
