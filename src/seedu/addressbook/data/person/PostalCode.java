package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * @author sharkey
 * Represents a postal code in an address
 * Guarantees immutable; is valid as declared in {@link #isValidName(String)}
 *
 */
public class PostalCode {
	

	public static final String EXAMPLE = "S640950";
	public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "A postal code should be in this format SXXXXXX";
	public static final String POSTALCODE_VALIDATION_REGEX = "S+[\\d ]+";
	public final String value;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostalCode other = (PostalCode) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostalCode [value=" + value + "]";
	}
	public PostalCode(String value) throws IllegalValueException {
		if (!isValidPostalcode(value)) {
			throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
		}
		this.value = value;
	}
	
	private boolean isValidPostalcode(String test) {
		
		return test.matches(POSTALCODE_VALIDATION_REGEX);
	}
	
	

}
