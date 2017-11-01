package fil.coo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fil.coo.Actions.Actions;
import fil.coo.Actions.Move;
import fil.coo.character.Player;

public class TestMove {

	@Test
	public void testMove() {
		Room roomStart = new Room();
		Room secondRoom = new Room();
		Player p = new Player("Test", 10, 2, 20, roomStart, new ArrayList<Actions>());
		roomStart.addRandomMonster();
		
		Move move = new Move();
		
		assertTrue(!move.conditionToUse(p));

		// Clear RoomListMonster
		int taille = roomStart.getListMonster().size();
		for (int i = 0; i < taille; i++)
			roomStart.getListMonster().remove(0);

		assertTrue(move.conditionToUse(p));
		
		move.moveToNextRoom(p, secondRoom);
		
		assertEquals(p.getCurrentRoom(),secondRoom);
		
	}
}
