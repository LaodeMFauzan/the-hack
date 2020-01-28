package com.fauzan.project.hack.service;

import com.fauzan.project.hack.dao.PersonDao;
import com.fauzan.project.hack.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */
@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao")  PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(  person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person updatedPerson){
        return personDao.updatePerson(id, updatedPerson);
    }
}
