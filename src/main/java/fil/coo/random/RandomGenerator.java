package fil.coo.random;

import fil.coo.Dungeon;

public class RandomGenerator {
	
	static public int randomInt(int min, int max) {
	
	int randomInt = Dungeon.seed.nextInt(max - min + 1) + min;	
	return randomInt;
	}
	
	static public int randomInt(int max) {
		int min = 0;
		int randomInt = Dungeon.seed.nextInt(max - min + 1) + min;	
		return randomInt;
	}
}
