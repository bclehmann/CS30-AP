package haiku;

import java.util.Scanner;

public class IA7_Haiku {
	public static final String haikuFileDir="src/haiku/";

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Scanner wordscan = new Scanner(System.in);
		
		System.out.println("Which poem would you like?");
		String filename=haikuFileDir+wordscan.nextLine();
		
		String[] originalHaiku=FileOperations.loadStringArr(filename);
		
		System.out.println("ORIGINAL HAIKU");
		for(String curr: originalHaiku) {
			System.out.println(curr);
		}
		
		
		//I used insertion sort here
		String[] sortedHaiku=originalHaiku;
		for(int i=0; i<sortedHaiku.length; i++) {
			for(int j=0; j<sortedHaiku.length; j++) {
				if(shouldSwap(sortedHaiku[j], sortedHaiku[i])) {
					String temp= sortedHaiku[i];
					sortedHaiku[i]=sortedHaiku[j];
					sortedHaiku[j]=temp;
				}
			}
		}
		
		
		System.out.println();
		System.out.println("SORTED HAIKU");
		for(String curr: sortedHaiku) {
			System.out.println(curr);
		}
		
		System.out.println();
		System.out.println("Couprie, I hear you can improve this with your wisdom");
		System.out.println("Type a word you want to replace");
		String target=wordscan.nextLine();
		System.out.println("Replace "+target+" with what?");
		String replace=wordscan.nextLine();
		
		for(int i=0; i< sortedHaiku.length; i++) {
			sortedHaiku[i]=sortedHaiku[i].replace(target, replace);
		}
		
		System.out.println();
		System.out.println("SORTED HAIKU");
		for(String curr: sortedHaiku) {
			System.out.println(curr);
		}
		
		
		boolean valid=false;
		System.out.println();
		while(!valid) {
			System.out.println("Do you want to save? (Y/N)");
			switch(wordscan.nextLine().toUpperCase()) {
				case "Y":
					FileOperations.saveStringArray(filename, sortedHaiku);
					valid=true;
					break;
				case "N":
					valid=true;
					break;
			}
			
		}
		wordscan.close();
	}
	
	public static boolean shouldSwap(String a, String b) {
		for(int i=0; i< b.length(); i++) {
			if(!(i<a.length())) {
				return true;
			}
			if(a.charAt(i)!= b.charAt(i)) {
				return (int) b.charAt(i) < (int) a.charAt(i);
			}
		}
		
		return false;
	}

}
