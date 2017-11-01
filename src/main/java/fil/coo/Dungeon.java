package fil.coo;

import java.util.ArrayList;
import java.util.Random;

import Displayer.*;
import scanner.ScannerInt;
import fil.coo.Actions.*;
import fil.coo.character.Player;
import fil.coo.random.RandomGenerator;


public class Dungeon {
	
	protected ArrayList<Room> roomList;
	private static final int NB_ROOM = 20;
	private static final int NB_LINK_LOOP = 2;
	public static Display myDisplayer= new DisplayerText();
	public static Random seed = new Random() ;

	
	/**
	 * Constructor to create to play in the dungeon
	 */
	public Dungeon() {
		//Initialization of the Dungeon
		roomList = new ArrayList<Room>();
		this.addAllRooms();
		this.createExit();
		this.linkRoomsNb(NB_LINK_LOOP);
		
		
	}
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	
	
	public static int getNbRoom() {
		return NB_ROOM;
	}

	public void playDungeon() {
		//Initialization of the player
		Player player = this.createPlayer();		
		
		//Game	
		this.game(player);		
		
		//End of the Game
		this.endOfDungeon(player);
	}
	
	/**
	 * Method to add NB_ROOM random rooms
	 */
	public void addAllRooms() {
		for (int i=0; i<NB_ROOM; i++) {
			Room newRoom = new Room();
			newRoom.fillRoom();
			this.roomList.add(newRoom);
		}
	}
	
	/**
	 * method to create the exit of the dungeon (but not the first room)
	 */
	public void createExit() {
		int nbRoomExit = RandomGenerator.randomInt(1, NB_ROOM-1);
		this.roomList.get(nbRoomExit).setExitOpen(true);
	}
	
	/**
	 * Method to link all rooms randomly
	 */
	public void linkRooms() {
		for (int i=0; i<this.roomList.size(); i++) {
			
			//link is the index of the room to link, initialize to i so the following boolean is false
			int link = i;
			
			//the room can be linked if it's not itself and if it isn't already linked (contains in the nextRooms list)
			boolean canBeAdded = link != i && !this.roomList.get(i).getNextRooms().contains(this.roomList.get(link));
			while (!canBeAdded) {
				link = RandomGenerator.randomInt(NB_ROOM-1);
				canBeAdded = link != i && !this.roomList.get(i).getNextRooms().contains(this.roomList.get(link));
			}
			
			//the room can be added/linked
			this.roomList.get(i).addNextRoom(this.roomList.get(link));
		}
	}
	
	/**
	 * Call linkRoom (all the loop for upside) nbLinkLoop times
	 * @param nbLinkLoop .
	 */
	public void linkRoomsNb (int nbLinkLoop) {
		for (int i=0; i<nbLinkLoop; i++) {
			this.linkRooms();
		}
	}
	
	/**
	 * create a player into the dungeon to start playing with all the actions.
	 * @return a new Player with all the actions.
	 */
	public Player createPlayer() {
		ArrayList<Actions> playerActions = new ArrayList<Actions>();
		playerActions.add(new Look());
		playerActions.add(new UseItem());
		playerActions.add(new Move());
		playerActions.add(new Attack());
		playerActions.add(new Exit());
		
		String name = ScannerInt.readString("What's your name ?");
		return new Player(name, 20, 4, 0, this.roomList.get(0), playerActions);
	}
	
	/**
	 * Method to test if the Player has won the game or not. 
	 * @param player.
	 */
	public void endOfDungeon(Player player) {
		if (player.getPointLife()>0) {
			Dungeon.myDisplayer.display("Congratulations, you won !");
		}
		
		else {
			Dungeon.myDisplayer.display("The dungeon was stronger !");
		}	
	}
	
	public void game(Player player) {
		ArrayList<Actions> possibleActions = new ArrayList<Actions>();
		
		while (!player.isDungeonOver()) {
			Dungeon.myDisplayer.display("------");
			Dungeon.myDisplayer.display(player.description());
			
			possibleActions = player.possibleAction();
			Actions actionChosen = player.chooseAction("Choose an action", possibleActions);
			if (actionChosen!=null) actionChosen.execute(player);
		}
	}
}
