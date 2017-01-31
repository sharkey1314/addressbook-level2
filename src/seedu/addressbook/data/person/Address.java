package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "Jurong West St 91, Blk 950, #05-621, S640950";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address should be in 'STREET,BLOCK,UNIT,POSTALCODE' format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_DELIMITER = ",";
    
    private String[] addressData;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    public Block getBlock() {
		return block;
	}

	public Street getStreet() {
		return street;
	}

	public Unit getUnit() {
		return unit;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        addressData = address.split(ADDRESS_DELIMITER);
        this.street = new Street(addressData[0].trim());
        this.block = new Block(addressData[1].trim());
        this.unit = new Unit(addressData[2].trim());
        this.postalCode = new PostalCode(addressData[3].trim());
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX) && (test.split(ADDRESS_DELIMITER).length == 4);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
