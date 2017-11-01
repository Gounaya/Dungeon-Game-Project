package fil.coo.item;

import fil.coo.character.Character;
import fil.coo.random.RandomGenerator;

public class LifePotion implements Item {
	
	protected int value;
	private static final int MIN_VALUE_LIFEPOTION = 1;
	private static final int MAX_VALUE_LIFEPOTION = 10;
	
	/**
	 * constructor to LifePotion 
	 * @param value.
	 */
	public LifePotion(int value) {
		this.value = value;
	}
	
	/**
	 * Constructor to give a Minimum and Maximum for the value of the LifePOtion and fix it at a number constant 
	 */
	public LifePotion() {
		this.value = RandomGenerator.randomInt(MIN_VALUE_LIFEPOTION,MAX_VALUE_LIFEPOTION);
	}
    
	/**
	 * getter to have the value of the lifePoint.
	 * @return value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Method use is to add life to the target
	 */
	public void use(Character target) {
		target.setPointLife(target.getPointLife()+this.value);		
	}
	
	@Override
	public String toString() {
		return "A " + getValue() + " Life Potion\n";
	}
	
	/**
	 * description of the LifePotion
	 */
	public String description() {
		return "A life potion. It can heal me for " +getValue() +".\n";
	}
}
