package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.character.Monster;
import fil.coo.character.Player;

public class TestMonster {

	@Test
	public void testMonster() {
		Room roomStart = new Room();
		Monster m = new Monster(10,5,0, roomStart);
		Player p = new Player("Test", 10, 2, 20, roomStart, new ArrayList<Actions>());
		
		m.riposte(p);
		assertTrue(p.getPointLife() == 5);
	}
	
}
