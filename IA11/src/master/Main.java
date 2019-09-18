package master;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rand= new Random();
		int[] arr = new int[500000];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		
		int wanted= arr[rand.nextInt(arr.length)];
		
		System.out.println("Linear Search");
		Instant t1= Instant.now();
		Search.linearSearch(arr, wanted);
		Instant t2= Instant.now();
		System.out.printf("\t%d%n", getTimeDifference(t2,t1));
		
		wanted= arr[rand.nextInt(arr.length)];
		
		System.out.println("Binary Search");
		Instant t3= Instant.now(); 
		Search.binarySearch(arr, wanted);
		Instant t4= Instant.now(); 
		System.out.printf("\t%d%n", getTimeDifference(t4,t3));
		
		int[] sortArr = new int[50000];
		for(int i=0; i<sortArr.length; i++) {
			sortArr[i]=rand.nextInt();
		}
		
		System.out.println("Sorts:");
		System.out.println();
		
		
		System.out.println("Bubble (slow)");
		Instant t5= Instant.now();
		Sort.bubble(sortArr, false);
		Instant t6= Instant.now();
		System.out.printf("\t%d%n", getTimeDifference(t6,t5));
		
		for(int i=0; i<sortArr.length; i++) {
			sortArr[i]=rand.nextInt();
		}
		
		System.out.println("Insert");
		Instant t7= Instant.now();
		Sort.insert(sortArr);
		Instant t8= Instant.now();
		System.out.printf("\t%d%n", getTimeDifference(t8,t7));
		
		for(int i=0; i<sortArr.length; i++) {
			sortArr[i]=rand.nextInt();
		}
		
		System.out.println("Selecc");
		Instant t9= Instant.now();
		Sort.selecc(sortArr);
		Instant t10= Instant.now();
		System.out.printf("\t%d%n", getTimeDifference(t10,t9));
		
		for(int i=0; i<sortArr.length; i++) {
			sortArr[i]=rand.nextInt();
		}
		
		System.out.println("Bubble (less slow)");
		Instant t11= Instant.now();
		Sort.bubble(sortArr, true);
		Instant t12= Instant.now();
		System.out.printf("\t%d%n", getTimeDifference(t12,t11));
		
	}
	
	private static long getTimeDifference(Instant a, Instant b) {
		long secondDifference=a.getEpochSecond() - b.getEpochSecond();
		long nanoDifference= a.getNano() - b.getNano();
		
		return (long) (secondDifference * Math.pow(10, 9) + nanoDifference);
	}

}
