package root;

import java.util.ArrayList;
import java.util.Scanner;

public class IA8_ActorsMain {

	public static void main(String[] args) {
		// System.out.println(System.getProperty("user.dir"));
		String[] fileContents = Files.loadStringArr("HamletActors.txt");
		ArrayList<Actor> actorList = new ArrayList<Actor>();
		int columnsPerActor = 5;
		Scanner wordscan = new Scanner(System.in);
		Scanner numscan = new Scanner(System.in);

		String assembledActor = "";
		for (int i = 0; i < fileContents.length + 1; i++) {
			if (i % columnsPerActor == 0 && i != 0 || i == fileContents.length) {
				String[] fields = assembledActor.split(",");

				String fname = fields[0];
				String lname = fields[1];
				int dayShooting = Integer.parseInt(fields[2]);
				boolean promoTeam = fields[3].equalsIgnoreCase("true");
				String role = fields[4];

				Actor temp = new Actor(fname, lname, dayShooting, promoTeam, role);
				actorList.add(temp);
				assembledActor = "";

			}
			if (i != fileContents.length) {
				if (i % columnsPerActor == 0) {
					assembledActor += fileContents[i];
				} else {
					assembledActor += "," + fileContents[i];
				}
			}

		}

		boolean keepLooping = true;
		while (keepLooping) {
			System.out.println("MENU");
			System.out.println("----------------");
			System.out.println("1: Seach by last name");
			System.out.println("2: Seach by role");
			System.out.println("3: List promotional tour");
			System.out.println("4: List actors currently on set");
			System.out.println("5: Exit");

			int wanted = numscan.nextInt();
			switch (wanted) {
			case 1:
				System.out.println("What is the actor's last name?");
				searchLastName(wordscan.nextLine(), actorList);
				break;
			case 2:
				System.out.println("What is the actor's role?");
				searchRole(wordscan.nextLine(), actorList);
				break;
			case 3:
				listPromoTour(actorList);
				break;
			case 4:
				System.out.println("What shooting day?");
				listActorsOnSet(numscan.nextInt(), actorList);
				break;
			case 5:
				keepLooping = false;
				break;
			}

		}

	}

	private static void searchRole(String role, ArrayList<Actor> actorList) {
		int middle = actorList.size() / 2;
		while (true) {
			Actor middleActor = actorList.get(middle);
			if (middleActor.role.equalsIgnoreCase(role)) {
				System.out.println(middleActor);
				return;
			} else if ((int) middleActor.role.charAt(0) < (int) role.charAt(0)) {
				middle += (int) Math.ceil((actorList.size() - middle) / 2.0);
			} else {
				middle /= 2;
			}

			if (middle < 0 || middle == actorList.size()) {
				System.out.println("Not found");
				return;
			}
		}
	}

	private static void listActorsOnSet(int shootingDay, ArrayList<Actor> actorList) {
		for(Actor curr: actorList) {
			if(curr.dayShooting == shootingDay) {
				System.out.println(curr);
			}
		}
	}

	private static void listPromoTour(ArrayList<Actor> actorList) {
		for(Actor curr: actorList) {
			if(curr.promoTeam) {
				System.out.println(curr);
			}
		}
	}

	private static void searchLastName(String lastName, ArrayList<Actor> actorList) {
		for (Actor curr : actorList) {
			if (curr.lastName.equalsIgnoreCase(lastName)) {
				System.out.println(curr);
				return;
			}
		}

		System.out.println("Not found");
	}

}
