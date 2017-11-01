package fil.coo.item;

import fil.coo.character.Character;
import fil.coo.random.RandomGenerator;

public class PurseOfGold implements Item {
	
	protected int value;
	private static final int MAX_VALUE_GOLDPURSE = 5;
	private static final int MIN_VALUE_GOLDPURSE = 1;

	/**
	 * Constructor with only on Parameter
	 * @param value.
	 */
	public PurseOfGold(int value) {
		this.value = value;
	}
	
	/**
	 * Constructor with a random to fix a Max and a Minimum for the number of the gold Purse.
	 */
	public PurseOfGold() {
		this.value = RandomGenerator.randomInt(MIN_VALUE_GOLDPURSE,MAX_VALUE_GOLDPURSE);
	}

	/**
	 * Method to use the purse of gold by the target 
	 */
	public void use(Character target) {
		target.setGold(target.getGold()+value);
	}
	
	    
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "A purse of " + getValue() + " gold \n";
	}

	/**
	 * Description of the purse of gold that have the character
	 */
	public String description() {
		return "A purse of gold !!! It contains " + getValue() + " pieces.\n";
	}
}
