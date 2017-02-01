package seedu.addressbook.common;

import java.util.List;

import seedu.addressbook.ui.TextUi;

public class Formatter {
	

    private static final int WELCOME_MESSAGE = 1;
    private static final int GOODBYE_MESSAGE = 2;
    private static final int INIT_FAILED_MESSAGE = 3;
    private static final int PERSON_LIST_VIEW = 4;
	private static final int RESULT_TO_USER = 5;
	private static final int COMMAND_ENTER = 6;
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public static String format(int type, String... message) {
    	String result = "";
    	switch (type) {
    	case WELCOME_MESSAGE: result = formatString(DIVIDER, DIVIDER, message[0], message[1], message[2], message[3], DIVIDER);
    			break;
    	case GOODBYE_MESSAGE: result = formatString(message[0], DIVIDER, DIVIDER);
    			break;
    	case INIT_FAILED_MESSAGE: result = formatString(message[0], DIVIDER, DIVIDER);
    			break;
    	case PERSON_LIST_VIEW: result = formatString(message);
    			break;
    	case RESULT_TO_USER: result = formatString(message);
    			break;
    	case COMMAND_ENTER: result = formatString(message);
    	}
    	return result;
    }
    
    public static String format(int type, List<String> message) {
    	String result = "";
    	switch (type) {
    	case PERSON_LIST_VIEW: result = formatString(getIndexedListForViewing(message));
    	break;
    	}
    	return result;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }


    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

	
	private static String formatString(String... message) {
		String formattedMsg = "";
        for (String m : message) {
            formattedMsg = formattedMsg + (LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX)) + LS;
        }
        return formattedMsg;
	}

}
