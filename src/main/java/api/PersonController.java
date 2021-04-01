package api;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;


@RequestMapping(value="api/v1/person",produces="application/json",
        method={RequestMethod.GET,
        RequestMethod.PUT,RequestMethod.POST})
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


}
