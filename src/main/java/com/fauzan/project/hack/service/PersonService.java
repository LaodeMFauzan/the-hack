package com.fauzan.project.hack.service;

import com.fauzan.project.hack.dao.PersonDao;
import com.fauzan.project.hack.model.Person;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(  person);
    }
}
