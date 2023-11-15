package org.ericwubbo.messagedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Seeder implements CommandLineRunner {

    private final PersonRepository personRepository;

    private final MessageRepository messageRepository;

    public Seeder(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (messageRepository.count() == 0) {
            var anton = createPerson("Anton");
            var bert = createPerson("Bert");
            var claudius = createPerson("Claudius");
            var message = createMessage(anton, "hello!", bert, claudius);
        }
    }

    private Message createMessage(Person sender, String text, Person... receivers) {
        var message = new Message(sender, text, Set.of(receivers));
        return messageRepository.save(message);
    }

    private Person createPerson(String name) {
        var person = new Person(name);
        return personRepository.save(person);
    }
}
