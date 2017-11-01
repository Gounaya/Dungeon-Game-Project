package fil.coo.character;

import java.util.ArrayList;

import fil.coo.Dungeon;
import fil.coo.Room;
import fil.coo.Actions.*;

import scanner.ScannerInt;

public class Player extends Character{
	
	private ArrayList<Actions> actions;
	private String name;
	private boolean dungeonOver = false;

	public Player(String name, int life, int strength, int gold, Room roomStrart, ArrayList<Actions> actions) {
		super(life, strength, gold, roomStrart);
		
		this.name = name;
		this.actions = actions;
	}
		
	public ArrayList<Actions> getActions() {
		return actions;
	}

	public String getName() {
		return name;
	}
	
	public boolean isDungeonOver() {
		return dungeonOver;
	}

	public void setDungeonOver(boolean dungeonOver) {
		this.dungeonOver = dungeonOver;
	}

	/**
	 * Choose an action in a list, by input
	 * @param message.
	 * @param listChoix.
	 * @return listChoix.
	 */
	public <T> T chooseAction(String message, ArrayList<T> listChoix) {
		Dungeon.myDisplayer.display("------");
		Dungeon.myDisplayer.display(message);
		int tailleListe = listChoix.size();
		for (int i = 1; i<= tailleListe; i++) {
			System.out.print("Choice n�" + i + " : " + listChoix.get(i-1)); 	
		}
		Dungeon.myDisplayer.display("Choice n�0 : Do nothing "); 	
		int selection = ScannerInt.readInt(tailleListe);
		
		if (selection == 0) return null;
		return listChoix.get(selection-1);
	}
	
	/**
	 * return all possible actions at the moment for the player 
	 * @return possibleActionList.
	 */
	public ArrayList<Actions> possibleAction() {
		ArrayList<Actions> possibleActionsList = new ArrayList<Actions>();
		for (int i=0; i<actions.size(); i++) {
			if (this.actions.get(i).conditionToUse(this))
			possibleActionsList.add(this.actions.get(i));
		}
		return possibleActionsList;
	}
	
	/**
	 * a Method for checking PointLIfe of the player, must be more then 0, else the player is dead. 
	 */
	public void checkLife() {
		if (this.dungeonOver = this.getPointLife() <= 0)
			Dungeon.myDisplayer.display("Mmmmh, youre dead !");;
		
	}
	
	@Override
	public String toString() {
		return getName() + " : " + this.getPointLife() + " Life Points / " + this.getStrength() + " Strength / " + this.getGold() + " golds !";
	}
	
	/**
	 * Description of the player, his PointLife, strength and Golds.
	 * @return String.
	 */
	public String description() {
		return "I have " + this.getPointLife() + " Life Points, " + this.getStrength() + " Strength and " + this.getGold() + " golds !" ;
	}

	public void riposte(Character c) {
		//For now, the Player is never attacked so this method does nothing.
		//Later, it can be implemented if there are more players
	}

}
