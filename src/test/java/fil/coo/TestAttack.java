package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.Actions.Attack;
import fil.coo.character.Monster;
import fil.coo.character.Player;

public class TestAttack {

	@Test
	public void testAttack() {
		Room roomStart = new Room();
		
		//Clear RoomListMonster
		int taille = roomStart.getListMonster().size();
		for (int i=0; i<taille; i++)	roomStart.getListMonster().remove(0);
		
		Player p = new Player("Test", 10, 2, 20, roomStart, new ArrayList<Actions>());
		Monster m = new Monster(4, 3, 10, roomStart);
		roomStart.getListMonster().add(m);
		
		Attack a = new Attack();
		a.attack(p, m);
		
		assertTrue(a.conditionToUse(p));
		
		//Monster ALive
		assertTrue(m.getPointLife() == 2);
		assertTrue(p.getPointLife() == 7);
		
		a.attack(p, m);
		//Monster Dead
		assertTrue(!roomStart.getListMonster().contains(m));
		assertTrue(p.getPointLife() == 7);
		
		//Monster drops golds
		roomStart.getListItem().get(roomStart.getListItem().size()-1).use(p);
		assertTrue(p.getGold() == 30);
		
		assertTrue(!a.conditionToUse(p));
	}
}
