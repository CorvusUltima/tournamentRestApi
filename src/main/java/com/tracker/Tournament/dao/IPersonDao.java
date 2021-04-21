package com.tracker.Tournament.dao;

import com.tracker.Tournament.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPersonDao
        extends JpaRepository<Person, UUID> {





}
