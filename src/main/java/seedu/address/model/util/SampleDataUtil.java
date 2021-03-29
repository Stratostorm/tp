package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Address;
import seedu.address.model.AddressBook;
import seedu.address.model.AppointmentBook;
import seedu.address.model.Name;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyAppointmentBook;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.DateTime;
import seedu.address.model.person.Email;
import seedu.address.model.person.Favourite;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TimeAdded;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"), new TimeAdded("2021-03-21 06:55:40.11"), new Favourite("false")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends"), new TimeAdded("2021-03-21 06:55:43.11"),
                new Favourite("true")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), getTagSet("neighbours"),
                new TimeAdded("2021-03-21 06:55:41.11"), new Favourite("false")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), getTagSet("family"),
                new TimeAdded("2021-03-21 06:55:42.11"), new Favourite("false")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), getTagSet("classmates"),
                new TimeAdded("2021-03-21 06:55:45.11"), new Favourite("false")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), getTagSet("colleagues"),
                new TimeAdded("2021-03-21 06:55:44.11"), new Favourite("false"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }


    public static Appointment[] getSampleAppointments() {
        Person[] samplePersons = getSamplePersons();

        return new Appointment[] {
            new Appointment(new Name("PTM"), new Address("ABC Primary School"),
                    new DateTime("21/03/2021 10:00"),
                    new HashSet<>(Arrays.asList(samplePersons[2]))),
            new Appointment(new Name("PSG meeting"), new Address("XYZ Secondary School"),
                    new DateTime("15/04/2021 14:00"),
                    new HashSet<>(Arrays.asList(samplePersons[5], samplePersons[1]))),
            new Appointment(new Name("Emily birthday party"), new Address("Our house"),
                    new DateTime("09/01/2022 18:00"), new HashSet<>())
        };
    }

    public static ReadOnlyAppointmentBook getSampleAppointmentBook() {
        AppointmentBook sampleAb = new AppointmentBook();
        for (Appointment sampleAppointment : getSampleAppointments()) {
            sampleAb.addAppointment(sampleAppointment);
        }
        return sampleAb;
    }

    /**
     * Returns a person set containing the list of strings given.
     */
    public static Set<Person> getPersonSet(String... strings) {
        return Arrays.stream(getSamplePersons())
                .collect(Collectors.toSet());
    }



}
