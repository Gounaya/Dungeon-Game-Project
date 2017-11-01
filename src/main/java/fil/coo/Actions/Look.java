package fil.coo.Actions;

import fil.coo.Dungeon;
import fil.coo.character.Player;

public class Look implements Actions {

	/**
	 * Method to give a description of the room
	 * @param player.
	 */
	public void execute(Player player)  {
		Dungeon.myDisplayer.display(player.getCurrentRoom().description());
	}

	/**
	 * method that we can always look around.
	 */
	public boolean conditionToUse(Player player) {
		return true;
	}
	
	@Override
	public String toString() {
		return "Look around\n";
	}
	
 
}
