package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.Actions.Exit;
import fil.coo.character.Player;

public class TestExit {

	
	@Test
	public void testExit() {
		Room exit = new Room();
		exit.setExitOpen(true);
		int taille = exit.getListMonster().size();
		for (int i=0; i<taille; i++)	exit.getListMonster().remove(0);
		Player p = new Player("Test", 10, 2, 20, exit, new ArrayList<Actions>());
		Exit e = new Exit();
		
		assertTrue(e.conditionToUse(p));
		
		e.execute(p);
		
		assertTrue(p.isDungeonOver());
	}
}
