package com.moss.rest.service;

import java.util.Collection;
import com.moss.rest.model.Person;

public interface PersonServiceInterface {

    Collection<Person> getAllPersons();

    Person getPerson(long id);

    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(long id);

}
