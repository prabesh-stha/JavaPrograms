package Lab1;

import java.util.Random;

public class SortNumberUsingArray {
	
	 public static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void printArray(int[] arr) {
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

	public static void main(String[] args) {
		
		String name = "Prashant";
		System.out.println("My name is " + 1);
	      Random random = new Random();
	        int length = random.nextInt(6) + 5;
	        int[] randomNumbers = new int[length];
	        for (int i = 0; i < length; i++) {
	            randomNumbers[i] = random.nextInt(100) + 1; 
	        }
	        System.out.println("Original Array:");
	        printArray(randomNumbers);
	        bubbleSort(randomNumbers);
	        System.out.println("\nSorted Array:");
	        printArray(randomNumbers);
	}

}
