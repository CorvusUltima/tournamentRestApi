package dao;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePersonAccessService implements  PersonDao{


    private static List<Person> DB =new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person)
    {
        DB.add(new Person(id,person.getName()));
        return 1;
    }






}
