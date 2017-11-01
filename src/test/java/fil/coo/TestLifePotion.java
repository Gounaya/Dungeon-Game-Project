package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.character.Player;
import fil.coo.item.LifePotion;

public class TestLifePotion {
	
	
	@Test
	public void testLifePotion() {
		Player p = new Player("Test", 10, 2, 20, new Room(), new ArrayList<Actions>());
		LifePotion lp = new LifePotion(8);
		lp.use(p);
		assertTrue(p.getPointLife() == 18);
	}
}
