package monster;

public class Tools {
	// Set up instance variables
	public String name;
	public int damage;
	public boolean consumable;
	public boolean selfActing;

	// Set up contructor method
	public Tools(String n, int d, boolean c, boolean s) {
		name = n;
		damage = d;
		consumable = c;
		selfActing = s;
	}

	// Set up instance methods if useful
	public String getDescription() {
		return String.format("A %s dealing %d damage%s%s", name, damage, consumable ? " (1 use)" : "", selfActing ? " (Self Acting)" : "");
	}



}
