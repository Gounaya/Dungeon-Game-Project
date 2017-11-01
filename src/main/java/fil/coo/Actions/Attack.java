package fil.coo.Actions;

import fil.coo.Dungeon;
import fil.coo.character.*;
import fil.coo.character.Character;
import fil.coo.item.PurseOfGold;

public class Attack implements Actions {
    
	/**
	 * Method execute is used to give the player the choice to attack the target.
	 * to execute this method the target must be in the same room with the player, and this one choose who attack. 
	 */
	public void execute(Player player) {
		Character target = player.chooseAction("Who do you want to attack ?", player.getCurrentRoom().getListMonster());
		if (target != null) attack(player, target);
	}
    
	/**
	 * Method attack is used to attack the target and do some damages at this character, and check his POint life after the attack 
	 * to know if the target is dead or not yet.
	 * @param player.
	 * @param target.
	 */

	public void attack(Player player, Character target) {
		target.setPointLife(target.getPointLife()-player.getStrength());
		Dungeon.myDisplayer.display("You dealt " + player.getStrength() + " damages");
		if (target.getPointLife() > 0)  targetAlive(player, target);		
		else 							targetDead(target);
	}
	
	/**
	 * Method targetDead is to check if the target is dead after the attack and say that it's dead.
	 * @param target.
	 */
	public void targetDead(Character target) {
		Dungeon.myDisplayer.display("Your target is dead ! Oh, it drops a purse in the room !");
		target.getCurrentRoom().getListItem().add(new PurseOfGold(target.getGold()));
		target.getCurrentRoom().getListMonster().remove(target);
	}
	
	/**
	 * Method targetAlive is to check if the target still alive after the attack
	 * @param player.
	 * @param target.
	 */
	public void targetAlive(Player player, Character target) {
		Dungeon.myDisplayer.display("Your target is still alive ! It hits you back and deals "+ target.getStrength() +" to you."); 
		target.riposte(player);
		player.checkLife();
	}
	
	/**
	 * Method to return true if the room is not empty
	 */
	public boolean conditionToUse(Player player) {
		return !player.getCurrentRoom().getListMonster().isEmpty();
	}

	@Override
	public String toString() {
		return "Attack a monster\n";
	}
	
}
