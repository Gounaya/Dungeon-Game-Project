package fil.coo.item;

import java.util.ArrayList;

import fil.coo.Dungeon;
import fil.coo.Actions.UseItem;
import fil.coo.character.Character;
import fil.coo.character.Player;
import fil.coo.random.RandomGenerator;

public class OneArmedBandit implements Item {

	protected int cost;
	private static final int MAX_VALUE_BANDIT = 12;
	private static final int MIN_VALUE_BANDIT = 6;

	/**
	 *  constructor with random value to fix it with a constant number Maximum and Minimum. 
	 */
	public OneArmedBandit() {
		this(RandomGenerator.randomInt(MIN_VALUE_BANDIT, MAX_VALUE_BANDIT));
	}
    /**
     *  Constructor to create oneArmedBandit with on parameter
     * @param cost.
     */
	public OneArmedBandit(int cost) {
		this.cost = cost;
	}

	/**
	 * Method to use the One Armed Bandit by the target 
	 */
	public void use(Character target) {
		if (target.getGold() >= cost) {
			// Paying
			target.setGold(target.getGold() - cost);

			// New item
			Item newItem = randomItem();

			// New action so the target is a Player and automatically use the
			// new item by an action (and execute the code linked to this
			// action)
			UseItem action = new UseItem();
			action.useItem((Player) target, newItem);
		} else
			Dungeon.myDisplayer.display("You don't have enougth money");
	}

	/**
	 *  generate a random item to buy
	 * @return allItem
	 */
	public Item randomItem() {
		ArrayList<Item> allItems = allKnownItems();
		int index = RandomGenerator.randomInt(0, allItems.size() - 1);

		return allItems.get(index);
	}

	/**
	 * ArrayList to add all known items except bandit in the list
	 * @return allItems
	 */
	public ArrayList<Item> allKnownItems() {
		ArrayList<Item> allItems = new ArrayList<Item>();

		allItems.add(new LifePotion());
		allItems.add(new StrengthPotion());
		allItems.add(new PurseOfGold());

		return allItems;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 *  String of the One Armed Bandit
	 */
	@Override
	public String toString() {
		return "An One Armed Bandit asking " + getCost() + " golds\n";
	}

	/**
	 *  description of the One Armed Bandit
	 */
	public String description() {
		return "An One Armed Bandit ! He asks me " + getCost()
				+ " pieces for a random Item. Maybe not worth..\n";
	}

}
