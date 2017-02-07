package seedu.addressbook.data.person;

public class Contact {
	
	public final String value;
	private boolean isPrivate;
	
	public Contact(String contact, boolean isPrivate) {
		String trimmedContact = contact.trim();
		this.value = trimmedContact;
		this.isPrivate = isPrivate;
		
	}
	
    public boolean isPrivate() {
        return isPrivate;
    }

	@Override
	public int hashCode() {
        return value.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		 return other == this // short circuit if same object
	                || (other instanceof Contact // instanceof handles nulls
	                && this.value.equals(((Contact) other).value)); // state check
	}

	@Override
	public String toString() {
		return value;
	}
	
	

}
