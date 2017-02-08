package seedu.addressbook.data.person;

import java.util.ArrayList;

import seedu.addressbook.data.tag.Tag;

public class Tagging {
	private Tag tag;
	private Person person;
	private String tagModifier;
	
	private static ArrayList<Tagging> taggings;
	
	
	public Tagging(Tag tag, Person person, String tagModifier) {
		this.tag = tag;
		this.person = person;
		this.tagModifier = tagModifier;
		
		taggings.add(this);
	}


	@Override
	public String toString() {
		return tagModifier + " " + person.getName() + " " + tag.tagName;
	}
	
	public String printAll() {
		String result = "";
		for (Tagging tagging : taggings) {
			result = result + tagging.toString() + "\\n";
		}
		return result;
	}
	
	public ArrayList<Tagging> getTaggings() {
		return taggings;
	}
	
	
	
	
	
}
