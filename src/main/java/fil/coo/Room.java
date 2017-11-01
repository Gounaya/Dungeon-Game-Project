package fil.coo;

import java.util.ArrayList;

import fil.coo.character.Monster;
import fil.coo.item.Item;
import fil.coo.item.LifePotion;
import fil.coo.item.OneArmedBandit;
import fil.coo.item.PurseOfGold;
import fil.coo.item.StrengthPotion;
import fil.coo.random.RandomGenerator;

public class Room {
	
	public static final int NB_MAX_MONSTER = 3;
	public static final int NB_MAX_ITEM = 3;
	public static int id_static_Room = 1;

	private int idRoom; 
	private ArrayList <Item> listItem;  
	private ArrayList <Monster> listMonster;
	private ArrayList <Room> nextRooms;
	private boolean exitOpen;
	
	/**
	 * Constructor to create a Room with an IdRoom, ListItem, ListMonster, ListOfNextRoom and an Exit. 
	 */
	public Room() {
		idRoom = Room.id_static_Room++;
		listItem = new ArrayList<Item>();
		listMonster = new ArrayList<Monster>();
		nextRooms  = new ArrayList<Room>();
		exitOpen = false;
	}
	
	/**
	 * Method to add another next room for both rooms (add a corridor)
	 * @param nextRoom .
	 */
	public void addNextRoom(Room nextRoom) {
		this.nextRooms.add(nextRoom);
		nextRoom.getNextRooms().add(this);
	}
	
	public ArrayList<Item> getListItem() {
		return listItem;
	}

	public ArrayList<Monster> getListMonster() {
		return listMonster;
	}

	public ArrayList<Room> getNextRooms() {
		return nextRooms;
	}

	public boolean isExitOpen() {
		return exitOpen;
	}

	public void setExitOpen(boolean exitOpen) {
		this.exitOpen = exitOpen;
	}

	/**
	 * Method to fill the room with monsters and items
	 */
	public void fillRoom() {
		this.addItems();
		this.addMonsters();
	}
	
	/**
	 * Method to add 0 to NB_MAX_ITEM random items to the room
	 */
	public void addItems() {
		int nbItem = RandomGenerator.randomInt(0,NB_MAX_ITEM);
		while (nbItem > 0) {
			this.addRandomItem();
			nbItem--;
		}
	}
	
	/**
	 * add a random Item
	 */
	public void addRandomItem() {
		ArrayList<Item> allItems = allKnownItems();
		int index = RandomGenerator.randomInt(0, allItems.size()-1);
		
		listItem.add(allItems.get(index));
	}

	
	/**
	 * Method to ArrayList with all known items
	 * @return allItems .
	 */
	public ArrayList<Item> allKnownItems() {
		ArrayList<Item> allItems = new ArrayList<Item>();
		
		allItems.add(new LifePotion());
		allItems.add(new StrengthPotion());
		allItems.add(new PurseOfGold());
		allItems.add(new OneArmedBandit());
		
		return allItems;
	}
	
	/**
	 * Method to add 0 to NB_MAX_MONSTERS random monsters to the room
	 */
	public void addMonsters() {
		int nbMonster = RandomGenerator.randomInt(NB_MAX_MONSTER);
		while (nbMonster > 0) {
			this.addRandomMonster();
			nbMonster--;
		}
	}
	
	/**
	 * Method to add a random Monster to the Room
	 */
	public void addRandomMonster() {
		Monster res = new Monster(this);
		listMonster.add(res);
	}
	
	@Override
	public String toString() {
		return "Room number : " + idRoom + "\n";	
	}
	
	/**
	 * Description of the room, all monsters and items inside
	 * @return res .
	 */
	public String description() {
		if (this.getListItem().isEmpty() && this.getListMonster().isEmpty()) return "There is nothing in this room...";		
		
		String res = "In this room, I can see :\n";
		for (int i=0; i<listMonster.size(); i++) {
			res += listMonster.get(i).description();
		}
		for (int i=0; i<listItem.size(); i++) {
			res += listItem.get(i).description();
		}
		res += "I can't see more...\n";
		return res;	
	}
}
