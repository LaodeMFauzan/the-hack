package com.fauzan.project.hack.dao;

import com.fauzan.project.hack.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */

public class PersonDataAccessService implements PersonDao {

    private static List<Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDB.add(new Person(id, person.getName()));
        return 1;
    }
}
