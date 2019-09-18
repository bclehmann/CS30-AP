package master;

public class Sort {
	public static int[] bubble(int[] arr, boolean optimize) {
		boolean swapped=true;
		int t=0;
		while(swapped) {
			swapped=false;
			for(int i=1; i< arr.length - t; i++) {
				if(arr[i] < arr[i-1]) {
					int temp=arr[i];
					arr[i]=arr[i-1];
					arr[i-1]=temp;
					swapped=true;
				}
			}
			if(optimize) {
				t++;
			}
		}
		return arr;
	}
	
	public static int[] insert(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[j] > arr[i]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selecc(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int minIndex=i;
			for(int j=i+1; j< arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					int temp=arr[j];
					arr[j]=arr[minIndex];
					arr[minIndex]=temp;
				}
			}
			
		}
		
		return arr;
	}
}
