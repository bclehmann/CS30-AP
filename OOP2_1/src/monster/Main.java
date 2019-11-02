package monster;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner wordscan = new Scanner(System.in);
		ArrayList<Monster> monsterList = new ArrayList<Monster>();

		monsterList.add(new Monster("zombie", 10));
		monsterList.add(new Monster("scrawny human", 15));
		monsterList.add(new Monster("human", 25));
		monsterList.add(new Monster("swole human", 35));
		monsterList.add(new Monster("soldier", 50));
		monsterList.add(new Monster("chad", 69));
		monsterList.add(new Monster("vampire", 100));
		monsterList.add(new Monster("demon", 150));
		monsterList.add(new Monster("banana slug", 175));
		monsterList.add(new Monster("matt", 200));

//		for(Monster curr : monsterList) {
//			System.out.printf("A %s with %d strength, %dhp and who is %s%n", curr.getType(), curr.getStrength(), curr.getHealth(), curr.getDescription());
//		}

//		System.out.println("What monster are you looking for?");
//		String searchName= wordscan.nextLine();
//		
//		for(Monster curr : monsterList) {
//			if(curr.getType().equalsIgnoreCase(searchName)) {
//				System.out.printf("A %s with %d strength, %dhp and who is %s%n", curr.getType(), curr.getStrength(), curr.getHealth(), curr.getDescription());
//				break;
//			}
//		}

		// Because aren't even the best of us monsters inside?
		Monster goodguy = new Monster("Really swole human", 80);

		int i;//I transcend loop structures
		for (i = 0; i < monsterList.size(); i++) {
			Monster curr = monsterList.get(i);
			if (goodguy.getHealth() <= 0) {
				break;
			}
			System.out.printf("A %s approaches with %d strength, %dhp and who is %s%n", curr.getType(),
					curr.getStrength(), curr.getHealth(), curr.getDescription());

			while (curr.getHealth() > 0 && goodguy.getHealth() > 0) {
				int dmg = goodguy.attacking();
				System.out.printf("You dealt %d damage to the monster!%n", dmg);
				curr.defending(dmg);
				System.out.printf("The monster has %d hp left%n", curr.getHealth() > 0 ? curr.getHealth() : 0);
				if (curr.getHealth() <= 0) {
					System.out.printf("You have defeated the %s!%n", curr.getType());
					break;
				}
				System.out.println();

				dmg = curr.attacking();
				System.out.printf("You took %d damage from the monster!%n", dmg);
				goodguy.defending(dmg);
				System.out.printf("You have %d hp left%n", goodguy.getHealth() > 0 ? goodguy.getHealth() : 0);
				if (goodguy.getHealth() <= 0) {
					System.out.println("You have died");
					System.out.println("Do you have a cheatcode?");
					if(wordscan.nextLine().equalsIgnoreCase("god")) {
						goodguy.setHealth(100);
					}
					
					break;
				}
				System.out.println();

			}

			System.out.println();
			System.out.println();
		}
		
		for(int j=0; j< i; j++) {
			monsterList.remove(0);//Always remove first element
		}

		for (Monster curr : monsterList) {
			System.out.printf("A %s with %d strength, %dhp and who is %s%n", curr.getType(), curr.getStrength(),
					curr.getHealth(), curr.getDescription());
		}

	}
}
