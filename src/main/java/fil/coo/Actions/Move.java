package fil.coo.Actions;

import fil.coo.Room;
import fil.coo.character.Player;

public class Move implements Actions {
	
	/**
	 * Method to give the player the chance to move into the room he chooses
	 */
	public void execute(Player player) {
		Room exit = player.chooseAction("Find your way out", player.getCurrentRoom().getNextRooms());
		if (exit!=null) 	moveToNextRoom(player, exit);
	}
	
	public void moveToNextRoom(Player player, Room exit) {
			player.setCurrentRoom(exit) ;
	}

	/**
	 * Method boolean the return true if the room is empty
	 */
	public boolean conditionToUse(Player player) {
		return player.getCurrentRoom().getListMonster().isEmpty();
	}

	@Override
	public String toString() {
		return "Move to a next Room\n";
	}
	
}


