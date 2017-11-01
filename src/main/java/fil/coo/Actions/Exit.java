package fil.coo.Actions;

import fil.coo.character.Player;

public class Exit implements Actions{

	
	public void execute(Player player) {
		player.setDungeonOver(true);		
	}
    /**
	 * check if it is an exit case.
	 * @return A boolean to say if it's an exit case.
	 */
	public boolean conditionToUse(Player player) {
		return (player.getCurrentRoom().getListMonster().isEmpty() && player.getCurrentRoom().isExitOpen());
	}
    
	@Override
	public String toString() {
		return "Exit the Dungeon\n";
	}
}
