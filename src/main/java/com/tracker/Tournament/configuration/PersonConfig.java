package com.tracker.Tournament.configuration;

import com.tracker.Tournament.dao.PersonDao;
import com.tracker.Tournament.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class PersonConfig {


    @Bean
    CommandLineRunner commandLineRunner(PersonDao repository){
        return args -> {


            Person Mile=new Person(

                    "Mile",
                    "Milenkovic",
                    "mile.milenkovic@gmail.com"
            );
            repository.insertPerson(Mile);
        };

    }



}
