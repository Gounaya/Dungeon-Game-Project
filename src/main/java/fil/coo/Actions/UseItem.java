package fil.coo.Actions;

import fil.coo.Dungeon;
import fil.coo.character.Player;
import fil.coo.item.Item;

public class UseItem implements Actions{

	/**
	 * method that give the player the chance to use the chosen item. The item disappears from the item list
	 * @param player.
	 */
	public void execute(Player player) {
		Item itemChoosen = player.chooseAction("Witch Item ?", player.getCurrentRoom().getListItem()) ;
		if (itemChoosen!=null)	{
			useItem(player, itemChoosen);
		}
	}
	
	/**
	 * Method that give the player the chance to use an Item from the List and remove it after the use. 
	 * @param player.
	 * @param item.
	 */
	public void useItem(Player player, Item item) {
		item.use(player) ;
		player.getCurrentRoom().getListItem().remove(item);
		Dungeon.myDisplayer.display("You used " + item);
	}
    
	//we can't use an item if there is no item
	public boolean conditionToUse(Player player) {
		return !player.getCurrentRoom().getListItem().isEmpty();
	}
	
	
	@Override
	public String toString() {
		return "Use an Item\n";
	}

}

