package master;

import java.util.Arrays;

public class Search {
	public static int linearSearch(int[] arr, int wanted) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==wanted) {
				return arr[i];
			}
		}
		
		return -1337;
		
	}
	
	public static int binarySearch(int[] arr, int wanted){
		int middle= (int) Math.ceil(arr.length/2.0) - 1;
		if(arr[middle]==wanted) {
			return arr[middle];
		}else if(arr[middle] < wanted) {
			return binarySearch(subArray(arr, middle + 1, arr.length - 1), wanted);
		}else{
			return binarySearch(subArray(arr, 0, middle - 1), wanted);
		}
	}
	
	private static int[] subArray(int[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end + 1);
	}

}
