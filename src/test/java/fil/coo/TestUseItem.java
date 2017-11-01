package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.Actions.UseItem;
import fil.coo.character.Player;
import fil.coo.item.LifePotion;

public class TestUseItem {

	@Test
	public void testUseItem() {
		Room roomStart = new Room();
		UseItem actionUseItem = new UseItem();
		
		//Clear RoomListItem
		int taille = roomStart.getListItem().size();
		for (int i=0; i<taille; i++)	roomStart.getListItem().remove(0);
		
		Player p = new Player("Test", 10, 2, 20, roomStart, new ArrayList<Actions>());
		
		assertTrue(!actionUseItem.conditionToUse(p));
		
		LifePotion lp = new LifePotion(10);
		roomStart.getListItem().add(lp);
		
		assertTrue(actionUseItem.conditionToUse(p));
		
		actionUseItem.useItem(p, lp);
		
		assertTrue(p.getPointLife() == 20);
		assertTrue(roomStart.getListItem().isEmpty());
	}
}
