package at.htl.qutedemo.control;

import at.htl.qutedemo.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository {
    private List<Person> persons = new ArrayList<>();

    public List<Person> findAll() {
        return persons;
    }

    public void add(Person person) {
        persons.add(person);
    }
}
