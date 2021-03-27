package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.appointment.Appointment;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyHeliBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Person> getPersonList();
    ObservableList<Appointment> getAppointmentList();

}
