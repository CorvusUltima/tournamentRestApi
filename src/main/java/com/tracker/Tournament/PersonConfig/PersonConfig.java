package com.tracker.Tournament.PersonConfig;


import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
   CommandLineRunner commandLineRunner (PersonRepository repository)
    {
        return args->{
         Person mile=  new Person (
               "mile"    ,
                   "kitic",
                   "@jahoo.com"
           ) ;
            Person djole=new Person(
                    "Djloe"    ,
                    "Mudic",
                    "@jahoo.com"
            ) ;

            repository.saveAll(
                    List.of(mile,djole)
            );


        };
    }




}
