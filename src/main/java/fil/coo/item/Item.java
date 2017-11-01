package fil.coo.item;

import fil.coo.character.Character;

public interface Item {
	
	public void use(Character target);
	
	public String description();
}
