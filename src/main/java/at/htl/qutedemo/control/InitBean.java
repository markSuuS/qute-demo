package at.htl.qutedemo.control;

import at.htl.qutedemo.entity.Address;
import at.htl.qutedemo.entity.Person;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class InitBean {
    @Inject
    PersonRepository personRepository;

    @Inject
    AddressRepository addressRepository;

    void startUp(@Observes StartupEvent ev) {
        Person moritz = new Person("Moritz", "Gruber", LocalDate.of(2006,5,5));
        Person philipp = new Person("Philipp", "Horner", LocalDate.of(2005,11,8));
        Person lukas = new Person("Lukas", "Sonnleitner", LocalDate.of(2006,2,28));

        Address gruber = new Address("Im Kornfeld", 10, "4490", "St. Florian");
        Address horner = new Address("Schulstraße", 14, "4491", "Niederneukirchen");
        Address sonnleitner = new Address("Bernsteingasse", 5, "4062", "Thening");

        moritz.setAddress(gruber);
        philipp.setAddress(horner);
        lukas.setAddress(sonnleitner);

        personRepository.add(moritz);
        personRepository.add(philipp);
        personRepository.add(lukas);

        addressRepository.add(gruber);
        addressRepository.add(horner);
        addressRepository.add(sonnleitner);
    }
}
