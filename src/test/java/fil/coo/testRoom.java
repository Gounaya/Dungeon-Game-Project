package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

public class testRoom {

	@Test
	public void testClassRoom() {
		Room r = new Room();
		
		//Clear RoomListMonster
		int taille = r.getListMonster().size();
		for (int i=0; i<taille; i++)	r.getListMonster().remove(0);
		//Clear RoomListItem
		taille = r.getListItem().size();
		for (int i=0; i<taille; i++)	r.getListItem().remove(0);
		
		assertTrue(r.getListMonster().isEmpty());
		assertTrue(r.getListItem().isEmpty());
		
		r.addRandomMonster();
		assertTrue(!r.getListMonster().isEmpty());
		
		r.addRandomItem();
		assertTrue(!r.getListItem().isEmpty());
	}
}
