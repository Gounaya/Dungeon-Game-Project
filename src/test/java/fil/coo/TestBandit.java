package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import fil.coo.Actions.*;
import fil.coo.character.Player;
import fil.coo.item.Item;
import fil.coo.item.LifePotion;
import fil.coo.item.OneArmedBandit;

public class TestBandit {
	
	public class MockBandit extends OneArmedBandit {
		
		public MockBandit() {
			super();
		}
		
		@Override
		public Item randomItem() {
			return new LifePotion(8);
		}
	}
	
	@Test
	public void testBandit() {
		Player p = new Player("Test", 10, 2, 20, new Room(), new ArrayList<Actions>());
		MockBandit bandit = new MockBandit();
		bandit.use(p);
		assertTrue(p.getPointLife() == 18);
	}
}
