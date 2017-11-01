package fil.coo.character;

import fil.coo.Room;

public abstract class Character {
	
	protected int pointLife;
	protected int strength;
	protected int gold;
	protected Room currentRoom;
	
	/**
	 * Constructor to create a new character without parameter. 
	 */
	public Character() {
		pointLife = 0;
		strength = 0;
		gold = 0;
		currentRoom = null;
	}
	
	public Character(int life, int strength, int gold, Room currentRoom) {
		this.pointLife = life;
		this.strength = strength;
		this.gold = gold;
		this.currentRoom = currentRoom;
	}
	
	public Character(int life, int strength, int gold) {
		this(life, strength, gold, null);
	}
	
	/**
	 * getter to get the Point of Life of the character 
	 * @return pointLife.
	 */
	public int getPointLife() {
		return pointLife;
	}
    
	/**
	 * setter for PointLife
	 * @param pointLife.
	 */
    public void setPointLife(int pointLife) {
		this.pointLife = pointLife;
	}

    /**
	 * getter to get strength of the character 
	 * @return  strength.
	 */
    
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
    
	/**
	 * getter to get gold of the character 
	 * @return gold.
	 */
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
    
	/**
	 * getter to get strength of the character 
	 * @return currentRoom.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
    
	/**
	 * setter currentRoom of the character 
	 * @param currentRoom.
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
    /**
     * an abstract Method to attack and this one exist in the class daughter 
     * @param c.
     */
	public abstract void riposte(Character c);
	
	
}
