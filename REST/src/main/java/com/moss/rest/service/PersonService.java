package com.moss.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.moss.rest.model.Person;

public class PersonService implements PersonServiceInterface {

    public static HashMap<Long, Person> persons = new HashMap<>();
    
    @Override
    public Collection<Person> getAllPersons() {
        return new ArrayList<Person>(persons.values());
    }

    @Override
    public Person getPerson(long id) {
        return persons.get(id);
    }

    @Override
    public void addPerson(Person person) {
        person.setId(persons.size());
        persons.put(person.getId(), person);
    }

    @Override
    public void updatePerson(Person person) {
        long id = person.getId();
        persons.put(id, person);
    }

    @Override
    public void deletePerson(long id) {
        persons.remove(id);
    }

}
