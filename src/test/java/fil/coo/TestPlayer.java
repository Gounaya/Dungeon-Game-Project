package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.character.Player;

public class TestPlayer {

	@Test
	public void testPlayer() {
		Player p = new Player("Test", 0, 2, 20, new Room(), new ArrayList<Actions>());
		
		p.checkLife();
		
		assertTrue(p.isDungeonOver());
	}
}
