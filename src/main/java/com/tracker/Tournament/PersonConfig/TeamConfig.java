package com.tracker.Tournament.PersonConfig;

import com.tracker.Tournament.Repository.PersonRepository;
import com.tracker.Tournament.Repository.TeamRepository;
import com.tracker.Tournament.model.Person;
import com.tracker.Tournament.model.Team;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TeamConfig {


    @Bean
    CommandLineRunner commandLineRunner(TeamRepository repository) {
        return args ->
        {
            Team tigar = new Team(
                    "Tigrovi Beli "
            );

            repository.saveAll(
                    List.of(tigar));
        };
    }
}
