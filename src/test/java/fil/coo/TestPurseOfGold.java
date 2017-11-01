package fil.coo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.character.Player;
import fil.coo.item.PurseOfGold;

public class TestPurseOfGold {

	@Test
	public void testPurseOfGold() {
		Player p = new Player("Test", 10, 2, 20, new Room(), new ArrayList<Actions>());
		PurseOfGold pg = new PurseOfGold(8);
		pg.use(p);
		assertTrue(p.getGold() == 28);
	}
}
