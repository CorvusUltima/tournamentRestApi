package com.tracker.Tournament.service;


import com.tracker.Tournament.dao.IPersonDao;
import com.tracker.Tournament.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceNew {
    private final IPersonDao ipersondao;

    @Autowired
    public PersonServiceNew(IPersonDao ipersondao) {
        this.ipersondao = ipersondao;
    }

    public List<Person> getAllPeople(){

        return ipersondao.findAll();
    }







}
