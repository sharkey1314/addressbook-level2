package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * @author sharkey
 * Represents the street name in an address
 * Guarantees immutable; is valid as declared in {@link #isValidName(String)}
 *
 */
public class Street {
	
	public static final String EXAMPLE = "Jurong West St 91";
	public static final String MESSAGE_STREET_CONSTRAINTS = "Sensible Street Names";
	public static final String STREET_VALIDATION_REGEX = ".+";
	
	public final String value;

	public Street(String value) throws IllegalValueException {
		if (!isValidStreet(value)) {
			throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
		}
		this.value = value;
	}

	public static boolean isValidStreet(String test) {
		return test.matches(STREET_VALIDATION_REGEX);
	}

	@Override
	public String toString() {
		return value;
	}
	
	

}
