package scanner;

import java.util.*;

import fil.coo.Dungeon;

public class ScannerInt {
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Method to read the next Integer
	 * @param n.
	 * @return input.
	 */
	public static int readInt(int n) {
		int input = -1;
		while (input < 0 || input > n) {
			Dungeon.myDisplayer.display("Write your choice between 0 and " + n +"\n");
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		} 
		return input;
	}

	/**
	 * method to read the next String
	 * @param message.
	 * @return read.
	 */
	public static String readString(String message) {	
		Dungeon.myDisplayer.display(message);
		String read = scanner.next(); // Scans the next token of the input as an int.
		return read;
	}
}
