package fil.coo.character;

import fil.coo.Room;
import fil.coo.random.RandomGenerator;

public class Monster extends Character {
	
	private final static int MIN_LIFE_MONSTER = 3;
	private final static int MAX_LIFE_MONSTER = 10;
	private final static int MIN_STRENGTH_MONSTER = 2;
	private final static int MAX_STRENGTH_MONSTER = 6;
	private final static int MIN_GOLD_MONSTER = 1;
	private final static int MAX_GOLD_MONSTER = 5;
	
	/**
	 * Constructor to create a Monster with 4 parameters 
	 * @param life.
	 * @param strength.
	 * @param gold.
	 * @param roomStart.
	 */
	public Monster(int life, int strength, int gold, Room roomStart) {
		super(life, strength, gold, roomStart);
	}
	
	/**
	 * Constructor with 3 random values for life, strength and gold, room is an attribute
	 * @param roomStart.
	 */
	public Monster(Room roomStart) {		
		super ( RandomGenerator.randomInt(MIN_LIFE_MONSTER, MAX_LIFE_MONSTER), 
				RandomGenerator.randomInt(MIN_STRENGTH_MONSTER,MAX_STRENGTH_MONSTER), 
				RandomGenerator.randomInt(MIN_GOLD_MONSTER,MAX_GOLD_MONSTER),
				roomStart);		
	}
	
	/**
	 * method ripest has the role to decrease the Point life of the character when the second character attack him 
	 * 
	 */
	public void riposte(Character attackingPlayer) {
		attackingPlayer.setPointLife(attackingPlayer.getPointLife()-this.strength);
	}
	
	/**
	 * A String to post information of the monster (his PointLIfe and his strength)
	 */
	@Override
	public String toString() {
		return "A " + getStrength() + "/" + getPointLife() + " Monster\n";
	}
	
	/**
	 * description of the monster, about his strength and PointLife
	 * @return 
	 */
	public String description() {
		return "Arg, a monster ! It has " + this.getStrength() + " strength and " + this.getPointLife() + " life points and a nice purse on his belt !\n";
	}
}
