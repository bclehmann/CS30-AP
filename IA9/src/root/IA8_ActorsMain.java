package root;

import java.util.ArrayList;
import java.util.Scanner;

public class IA8_ActorsMain {

	static enum options {
		SEARCH_BY_LASTNAME, SEARCH_BY_ROLE, LIST_PROMO, LIST_ON_SET, PRINT_FIRSTNAMES, PRINT_ROLES, EXIT, SEARCH_BY_FIRSTNAME
	}

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
			System.out.println("2: Seach by first name");
			System.out.println("3: Seach by role");
			System.out.println("4: List promotional tour");
			System.out.println("5: List actors currently on set");
			System.out.println("6: Print all first names");
			System.out.println("7: Print all roles");
			System.out.println("8: Exit");

			options[] optionsArr = { 
					options.SEARCH_BY_LASTNAME,
					options.SEARCH_BY_FIRSTNAME,
					options.SEARCH_BY_ROLE,
					options.LIST_PROMO,
					options.LIST_ON_SET,
					options.PRINT_FIRSTNAMES,
					options.PRINT_ROLES,
					options.EXIT
			};

			int wanted = numscan.nextInt();
			switch (optionsArr[wanted - 1]) {
			case SEARCH_BY_LASTNAME:
				System.out.println("What is the actor's last name?");
				searchByLastName(wordscan.nextLine(), actorList);
				break;
			case SEARCH_BY_ROLE:
				System.out.println("What is the actor's role?");
				searchByRole(wordscan.nextLine(), actorList);
				break;
			case LIST_PROMO:
				listPromoTour(actorList);
				break;
			case LIST_ON_SET:
				System.out.println("What shooting day?");
				listActorsOnSet(numscan.nextInt(), actorList);
				break;
			case PRINT_FIRSTNAMES:
				for (Actor curr : sortByFirstName(actorList)) {
					System.out.println("--" + curr.firstName);
				}
				break;
			case PRINT_ROLES:
				for (Actor curr : sortByRole(actorList)) {
					System.out.println("--" + curr.role);
				}
				break;
			case SEARCH_BY_FIRSTNAME:
				System.out.println("What is the actor's first name?");
				searchByFirstName(wordscan.nextLine(), actorList);
				break;
			case EXIT:
				keepLooping = false;
				break;
			}

		}

	}

	private static void searchByRole(String role, ArrayList<Actor> actorList) {
		ArrayList<Actor> sortedList= sortByRole((ArrayList<Actor>) actorList.clone());
		int middle = sortedList.size() / 2;
		while (true) {
			Actor middleActor = sortedList.get(middle);
			if (middleActor.role.equalsIgnoreCase(role)) {
				System.out.println("--" + middleActor);
				return;
			} else if ((int) middleActor.role.charAt(0) < (int) role.charAt(0)) {
				middle += (int) Math.ceil((sortedList.size() - middle) / 2.0);
			} else {
				middle /= 2;
			}

			if (middle < 0 || middle == sortedList.size()) {
				System.out.println("Not found");
				return;
			}
		}
	}
	
	private static void searchByFirstName(String firstName, ArrayList<Actor> actorList) {
		ArrayList<Actor> sortedList= sortByFirstName((ArrayList<Actor>) actorList.clone());
		int middle = sortedList.size() / 2;
		while (true) {
			Actor middleActor = sortedList.get(middle);
			if (middleActor.firstName.equalsIgnoreCase(firstName)) {
				System.out.println("--" + middleActor);
				return;
			} else if (shouldSwap(middleActor.firstName, firstName)) {
				middle += (int) Math.ceil((sortedList.size() - middle) / 2.0);
			} else {
				middle /= 2;
			}

			if (middle < 0 || middle == sortedList.size()) {
				System.out.println("Not found");
				return;
			}
		}
	}

	private static void listActorsOnSet(int shootingDay, ArrayList<Actor> actorList) {
		for (Actor curr : actorList) {
			if (curr.dayShooting == shootingDay) {
				System.out.println("--" + curr);
			}
		}
	}

	private static void listPromoTour(ArrayList<Actor> actorList) {
		for (Actor curr : actorList) {
			if (curr.promoTeam) {
				System.out.println("--" + curr);
			}
		}
	}

	private static void searchByLastName(String lastName, ArrayList<Actor> actorList) {
		for (Actor curr : actorList) {
			if (curr.lastName.equalsIgnoreCase(lastName)) {
				System.out.println("--" + curr);
				return;
			}
		}

		System.out.println("Not found");
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Actor> sortByFirstName(ArrayList<Actor> actorList) {
		ArrayList<Actor> outputList = (ArrayList<Actor>) actorList.clone();
		for (int i = 0; i < outputList.size(); i++) {
			int minimum = i;
			for (int j = i + 1; j < outputList.size(); j++) {
				if (shouldSwap(outputList.get(j).firstName, outputList.get(minimum).firstName)) {
					minimum = j;
				}
			}

			if (minimum != i) {
				Actor temp = outputList.get(i);
				outputList.set(i, outputList.get(minimum));
				outputList.set(minimum, temp);
			}
		}

		return outputList;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Actor> sortByRole(ArrayList<Actor> actorList) {
		ArrayList<Actor> outputList = (ArrayList<Actor>) actorList.clone();
		for (int i = 0; i < outputList.size(); i++) {
			int minimum = i;
			for (int j = i + 1; j < outputList.size(); j++) {
				if (shouldSwap(outputList.get(j).role, outputList.get(minimum).role)) {
					minimum = j;
				}
			}

			if (minimum != i) {
				Actor temp = outputList.get(i);
				outputList.set(i, outputList.get(minimum));
				outputList.set(minimum, temp);
			}
		}

		return outputList;
	}

	private static boolean shouldSwap(String a, String b) {
		a = a.toUpperCase();
		b = b.toUpperCase();
		for (int i = 0; i < a.length(); i++) {
			if (i == b.length()) {
				return true;
			}

			if (b.charAt(i) > a.charAt(i)) {
				return true;
			} else if (b.charAt(i) < a.charAt(i)) {
				return false;
			}
		}

		return false;
	}

}
