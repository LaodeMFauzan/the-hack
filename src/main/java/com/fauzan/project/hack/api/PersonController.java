package com.fauzan.project.hack.api;

import com.fauzan.project.hack.model.Person;
import com.fauzan.project.hack.service.PersonService;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
