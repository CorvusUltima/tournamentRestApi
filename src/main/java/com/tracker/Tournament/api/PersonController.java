package com.tracker.Tournament.api;

import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import com.tracker.Tournament.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tracker.Tournament.service.PersonService;

import java.util.List;
import java.util.Optional;

import static com.sun.beans.introspect.PropertyInfo.Name.required;


@RequestMapping(path="api/v1/person")
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

    @GetMapping(path="{teamId}/{teamsID}/{nesto}")// person can retrive date from team service
    public Optional<Team> getTeamById(@PathVariable("teamId") Long teamId)
    {
        return teamService.getTeamById(teamId);
    }

    @GetMapping(path="/{personId}/{teams}")// why is this not working
    public List<Team> getAllJoinedTeams(@PathVariable("personId") Long personId)
    {
        Person person= personService.getPersonById(personId).get();
        List<Team> teamJoined=person.getTeamJoined();
        Team team=new Team();
        teamJoined.add(team);
        return teamJoined;
    }

    @PostMapping(path="/{personId}/{teamId}")//why is this not working  ?
   public void  joinTeam(@PathVariable("personId") Long personId,
                         @PathVariable("teamId") Long teamId)
    {
        Person person = personService.getPersonById(personId).get();
        List<Team> teamJoined = person.getTeamJoined();
        Team team = teamService.getTeamById(teamId).get();
        teamJoined.add(team);
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
