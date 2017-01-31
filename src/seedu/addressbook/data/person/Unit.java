package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * @author sharkey
 * Represents an unit number in an address
 * Guarantees immutable; is valid as declared in {@link #isValidName(String)}
 *
 */
public class Unit {
	
	public static final String EXAMPLE = "#05-621";
	public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit number should be of the form #XYZ where XYZ are numbers";
	public static final String UNIT_VALIDATION_REGEX = "#(\\d)+-(\\d)+";
	public final String value;
	
	public Unit(String value) throws IllegalValueException {
		if (!isValidUnit(value)) {
			throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
		}
		this.value = value;
	}
	
	private boolean isValidUnit(String test) {
		return test.matches(UNIT_VALIDATION_REGEX);
	}

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
		Unit other = (Unit) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return value;
	}
	
	
}
