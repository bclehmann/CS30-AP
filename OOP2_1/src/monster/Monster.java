package monster;

import java.util.ArrayList;
import java.util.Scanner;

public class Monster {
	private String type;
	private int strength;// between 5 and 10
	private int health;
	private String description;
	public ArrayList<Tools> monsterInventory;
	private boolean playerControlled;

	// ************* constructor methods **************************
	public Monster(String t, int s, boolean pc) {
		type = t;
		strength = s/* +5 */;// parameter is a 1 to 5 value
		health = 100;

		String[] sizes = { "tiny", "tall", "giant" };
		String[] colors = { "green", "blue", "violet" };
		String[] look = { "gross", "sauve", "beguiling" };
		description = sizes[(int) (Math.random() * 3)] + ", " + colors[(int) (Math.random() * 3)] + ", "
				+ look[(int) (Math.random() * 3)];

		monsterInventory = new ArrayList<Tools>();
		playerControlled = pc;
	}

	public Monster(String t, int s, boolean pc, Tools... tools) {
		this(t, s, pc);
		for (Tools curr : tools) {
			this.addInventory(curr);
		}
	}

	// ********** getter methods ***********************
	public String getType() {
		return type;
	}

	public int getStrength() {
		return strength;
	}

	public int getHealth() {
		return health;
	}

	public String getDescription() {
		return description;
	}

	// ********** other methods **********************
	public void setHealth(int hp) {
		health = hp;
	}

	public int attacking() {
		// when the monster is attacking
		// returns the amount of damage done to the player
		int cappedHealth = health > 110 ? 110 : health; // Otherwise a HP kit lets the player 1-hit

		int baseDamage = (int) (strength * (cappedHealth / 100.0));
		int variance = (int) ((Math.random() - 0.5) * 10); // Variance of ± 5
		int damage = baseDamage + variance;

		if (monsterInventory.size() != 0) {
			int index = 0;
			if (playerControlled) {
				Scanner numscan = new Scanner(System.in);
				System.out.println("Type the number corresponding to the item you would like to use for this attack");
				printInventory();
				index = numscan.nextInt() - 1;
			} else {
				index = (int) (Math.random() * monsterInventory.size());
			}
			Tools tool = monsterInventory.get(index);

			if (tool.selfActing) {
				health += tool.damage;
			} else {
				damage += tool.damage;
			}

			String sign= tool.damage < 0 ? "-" : "+";
			System.out.printf("%s used %s%s, %s%d %s%n", type, tool.name, tool.selfActing ? " on self" : "", sign, Math.abs(tool.damage),
					tool.getClass() == HealthKit.class ? "HP healed" : "damage");

			if (tool.consumable) {
				monsterInventory.remove(index);
			}
		}

		return damage > 0 ? damage : 0; // Prevents negative damage due to variance
	}// end attack

	public int defending(int damage, Monster attacker) {
		// when the monster is defending
		// returns the current health of the monster after the attack

		health -= damage;

		if (health <= 0) {
			for (Tools curr : monsterInventory) {
				attacker.addInventory(curr);
			}
		}
		return health;
	}// end defend

	public void printInventory() {
		for (int i = 0; i < monsterInventory.size(); i++) {
			System.out.println((i + 1) + ": " + monsterInventory.get(i).getDescription());
		}
	}// end printInventory

	public void addInventory(Tools t) {
		monsterInventory.add(t);
	}// addInventory

	public ArrayList<Tools> getInventory() {
		return monsterInventory;
	}// end getInventory

}
