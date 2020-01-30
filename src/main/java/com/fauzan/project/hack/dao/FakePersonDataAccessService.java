package com.fauzan.project.hack.dao;

import com.fauzan.project.hack.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return personDB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personDB.stream().
                filter(person -> person.getId().equals(id)).
                findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if (person.isEmpty()){
            return 0;
        }
        personDB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int indexPersonToDelete = personDB.indexOf(p);
                    if (indexPersonToDelete >= 0){
                        p.setName(person.getName());
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
