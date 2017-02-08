package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;

public class Tagging {
	private Tag tag;
	private Person person;
	private String tagModifier;
	
	
	public Tagging(Tag tag, Person person, String tagModifier) {
		this.tag = tag;
		this.person = person;
		this.tagModifier = tagModifier;
	}


	@Override
	public String toString() {
		return tagModifier + " " + person.getName() + " " + tag.tagName;
	}
	
	
	
}
