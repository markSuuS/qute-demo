package at.htl.qutedemo;

import at.htl.qutedemo.control.AddressRepository;
import at.htl.qutedemo.control.PersonRepository;
import at.htl.qutedemo.entity.Address;
import at.htl.qutedemo.entity.Person;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("details-page")
public class DetailsPage {
    @Inject
    PersonRepository personRepository;

    @Inject
    AddressRepository addressRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance personData(List<Person> persons, List<Address> addresses);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(){
        return Templates.personData(personRepository.findAll(), addressRepository.findAll());
    }
}
