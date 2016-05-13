package com.moss.rest.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.moss.rest.model.Person;
import com.moss.rest.service.PersonService;


/**
 * Root resource (exposed at "persons" path)
 */
@Path("persons")
public class PersonResource {

    PersonService personService = new PersonService();

    @GET
    public Collection<Person> getPersons() {
        return personService.getAllPersons();
    }
    
    @GET
    @Path("/size")
    @Produces(MediaType.TEXT_PLAIN)
    public int getPersonsSize() {
        return personService.getAllPersons().size();
    }

    @GET
    @Path("/get/{id}")
    public Person getPerson(@PathParam("id") long id) {
        System.out.println("Getting person ID : " + id);
        return personService.getPerson(id);
    }

    @GET
    @Path("/add/{name}")
    public Person addPerson(@PathParam("name") String name) {
        Person person = new Person(name);
        personService.addPerson(person);
        return person;
    }

    @GET
    @Path("/delete/{personId}")
    public void deletePerson(@PathParam("personId") long personId) {
        personService.deletePerson(personId);
    }
}
