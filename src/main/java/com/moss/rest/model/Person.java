package com.moss.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private long id;
    private String name;

    public Person() {
        name = "Janusz";
    }

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
