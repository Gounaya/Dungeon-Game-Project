package fil.coo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.character.Player;
import fil.coo.item.StrengthPotion;

public class TestStrenghtPotion {
	
	@Test
	public void testStrenghtPotion() {
		Player p = new Player("Test", 10, 2, 20, new Room(), new ArrayList<Actions>());
		StrengthPotion sp = new StrengthPotion(2);
		sp.use(p);
		assertTrue(p.getStrength() == 4);
	}
}
