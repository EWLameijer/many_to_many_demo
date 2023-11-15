package org.ericwubbo.messagedemo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private Person sender;

    @ManyToMany
    private Set<Person> receivers = new HashSet<>();

    Message() {}

    public Message(Person sender, String text, Set<Person> receivers) {
        this.sender = sender;
        this.receivers = receivers;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Person getSender() {
        return sender;
    }

    public Set<Person> getReceivers() {
        return receivers;
    }
}
