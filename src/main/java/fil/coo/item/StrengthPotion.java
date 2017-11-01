package fil.coo.item;


import fil.coo.character.Character;
import fil.coo.random.RandomGenerator;

public class StrengthPotion implements Item{

	protected int value;
	private static final int MAX_VALUE_STRENGTHPOTION = 2;
	private static final int MIN_VALUE_STRENGTHPOTION = 1;
    
	/**
	 * Constructor to create a strengthPotion with on parameter
	 * @param value.
	 */
	public StrengthPotion(int value) {
		this.value = value;
	}
	
	/**
	 * Constructor with a random to fix a Max and a Minimum for the number of the strengthPotion.
	 */
	public StrengthPotion() {
		this.value = RandomGenerator.randomInt(MIN_VALUE_STRENGTHPOTION,MAX_VALUE_STRENGTHPOTION);
	}
    /**
     * Method to use the StrengthPotion by the target 
     */
	public void use(Character target) {
		target.setStrength(target.getStrength()+value);
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "A " + getValue() + " Strength Potion\n";
	}
 
	/**
	 * description of the strengthPotion
	 */
	public String description() {
		return "Strength potion for : " +getValue() + ". It makes me stronger !\n";
	}
	
}
