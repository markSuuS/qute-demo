package at.htl.qutedemo.control;

import at.htl.qutedemo.entity.Address;
import at.htl.qutedemo.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressRepository {
    private List<Address> addresses = new ArrayList<>();

    public List<Address> findAll() {
        return addresses;
    }

    public void add(Address address) {
        addresses.add(address);
    }
}
