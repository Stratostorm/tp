package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.contact.Contact;

/**
 * A utility class containing a list of {@code Contact} objects to be used in tests.
 */
public class TypicalContacts {

    public static final Contact ALICE = new ContactBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends")
            .withTimeAdded("2021-03-21 06:55:40.11")
            .withFavourite("false").build();
    public static final Contact BENSON = new ContactBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends")
            .withTimeAdded("2021-03-21 08:55:40.11")
            .withFavourite("false").build();
    public static final Contact CARL = new ContactBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withTimeAdded("2021-03-21 05:55:40.11")
            .withFavourite("false").build();
    public static final Contact DANIEL = new ContactBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends")
            .withTimeAdded("2021-03-21 07:55:40.11").withFavourite("true").build();
    public static final Contact ELLE = new ContactBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withTimeAdded("2021-03-21 09:55:40.11").withFavourite("false").build();
    public static final Contact FIONA = new ContactBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withTimeAdded("2021-03-21 06:57:40.11").withFavourite("true").build();
    public static final Contact GEORGE = new ContactBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withTimeAdded("2021-03-21 06:25:40.11")
            .withFavourite("false").build();

    // Manually added
    public static final Contact HOON = new ContactBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Contact IDA = new ContactBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

<<<<<<< Updated upstream:src/test/java/seedu/address/testutil/TypicalContacts.java
    // Manually added - Person's details found in {@code CommandTestUtil}
=======
    // Manually added - Contact's details found in {@code CommandTestUtil}
>>>>>>> Stashed changes:src/test/java/seedu/address/testutil/TypicalPersons.java
    public static final Contact AMY = new ContactBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Contact BOB = new ContactBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalContacts() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical contacts.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
<<<<<<< Updated upstream:src/test/java/seedu/address/testutil/TypicalContacts.java
        for (Contact contact : getTypicalPersons()) {
            ab.addPerson(contact);
=======
        for (Contact contact : getTypicalContacts()) {
            ab.addContact(contact);
>>>>>>> Stashed changes:src/test/java/seedu/address/testutil/TypicalPersons.java
        }
        return ab;
    }

<<<<<<< Updated upstream:src/test/java/seedu/address/testutil/TypicalContacts.java
    public static List<Contact> getTypicalPersons() {
=======
    public static List<Contact> getTypicalContacts() {
>>>>>>> Stashed changes:src/test/java/seedu/address/testutil/TypicalPersons.java
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
