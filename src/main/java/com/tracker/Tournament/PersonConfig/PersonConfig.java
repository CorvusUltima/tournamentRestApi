package com.tracker.Tournament.PersonConfig;


import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfig {


    @Bean
   CommandLineRunner commandLineRunner(PersonRepository repository)
    {
        return args->
        {
         Person mile= new Person (
                 1l,
               "mile"    ,
                   "kitic",
                   "@jahoo.com",
                 LocalDate.of(2000, Month.MAY,15)
         ) ;

            Person djole=new Person(
                    2l,
                    "Djloe",
                    "Mudic",
                    "@jahoo.com",
                    LocalDate.of(2000, Month.JULY,15)

            ) ;

            repository.saveAll(
                    List.of(mile,djole));
        };
    }




}
