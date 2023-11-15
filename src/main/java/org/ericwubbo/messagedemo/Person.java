package org.ericwubbo.messagedemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
