package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * @author sharkey
 * Represents a block number in an address
 * Guarantees immutable; is valid as declared in {@link #isValidName(String)}
 *
 */
public class Block {
	
	public static final String EXAMPLE = "950";
	public static final String MESSAGE_BLOCK_CONSTRAINTS = "A block can be anything";
	public static final String BLOCK_VALIDATION_REGEX = ".+";
	public final String block;
	
	
	/**
	 * 
	 * 
	 * @param block
	 * @throws IllegalValueException if given block is invalid
	 */
	public Block(String block) throws IllegalValueException {
		if (!isValidBlock(block)) {
			throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
		}
		this.block = block;
	}



	public static boolean isValidBlock(String test) {
		return test.matches(BLOCK_VALIDATION_REGEX);
	}
	
	


	@Override
	public String toString() {
		return block;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((block == null) ? 0 : block.hashCode());
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
		Block other = (Block) obj;
		if (block == null) {
			if (other.block != null)
				return false;
		} else if (!block.equals(other.block))
			return false;
		return true;
	}

	public String getBlock() {
		return block;
	}
	
}
