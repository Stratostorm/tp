package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditContactDescriptor;
import seedu.address.model.Address;
import seedu.address.model.Name;
import seedu.address.model.contact.Contact;
import seedu.address.model.contact.Email;
import seedu.address.model.contact.Phone;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditContactDescriptorBuilder {

    private EditCommand.EditContactDescriptor descriptor;

    public EditContactDescriptorBuilder() {
        descriptor = new EditCommand.EditContactDescriptor();
    }

    public EditContactDescriptorBuilder(EditContactDescriptor descriptor) {
        this.descriptor = new EditCommand.EditContactDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
<<<<<<< Updated upstream:src/test/java/seedu/address/testutil/EditContactDescriptorBuilder.java
    public EditPersonDescriptorBuilder(Contact contact) {
        descriptor = new EditPersonDescriptor();
=======
    public EditContactDescriptorBuilder(Contact contact) {
        descriptor = new EditContactDescriptor();
>>>>>>> Stashed changes:src/test/java/seedu/address/testutil/EditPersonDescriptorBuilder.java
        descriptor.setName(contact.getName());
        descriptor.setPhone(contact.getPhone());
        descriptor.setEmail(contact.getEmail());
        descriptor.setAddress(contact.getAddress());
        descriptor.setTags(contact.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditContactDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditContactDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditContactDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditContactDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditContactDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditContactDescriptor build() {
        return descriptor;
    }
}
