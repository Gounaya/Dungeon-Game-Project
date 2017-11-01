package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.Actions.Attack;
import fil.coo.Actions.Exit;
import fil.coo.Actions.Look;
import fil.coo.Actions.Move;
import fil.coo.Actions.UseItem;
import fil.coo.character.Player;

public class TestDungeon {
	
	public class MockDungeon extends Dungeon {
		
		public MockDungeon() {
			super();
		}
		
		@Override
		public void createExit() {
			int nbRoomExit = 1;
			this.roomList.get(nbRoomExit).setExitOpen(true);
		}
		
		@Override
		public Player createPlayer() {
			ArrayList<Actions> playerActions = new ArrayList<Actions>();
			playerActions.add(new Look());
			playerActions.add(new UseItem());
			playerActions.add(new Move());
			playerActions.add(new Attack());
			playerActions.add(new Exit());
			
			String name = "Lucien";
			return new Player(name, 20, 4, 0, this.roomList.get(0), playerActions);
		}
	}

	@Test
	public void testDungeon() {
		
		MockDungeon d = new MockDungeon();
		
		assertTrue(d.getRoomList().size() == Dungeon.getNbRoom());
		assertTrue(d.getRoomList().get(1).isExitOpen());
		
		d.linkRooms();
		
		for (int i=0; i<d.getRoomList().size(); i++)	
			assertTrue(!d.getRoomList().get(0).getNextRooms().isEmpty());
		
		Player p = d.createPlayer();
		
		assertEquals(p.getCurrentRoom(), d.getRoomList().get(0));
		assertTrue(!p.getActions().isEmpty());
	}
}
	

