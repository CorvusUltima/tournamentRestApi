package com.tracker.Tournament.service;


import com.tracker.Tournament.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public List<Person> getAllPeople() {
        return List.of(new Person(
                "mile",
                "djokic",
                "@gmail")
        );
    }
}
