package fil.coo.Actions;

import fil.coo.character.Player;

public interface Actions {
	
	public void execute(Player player);
	
	public boolean conditionToUse(Player player);
}
