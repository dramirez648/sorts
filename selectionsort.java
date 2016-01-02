// 	Name:			Daniel Ramirez
// 	Assignment #:	5
// 	Problem #:		2

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	    System.out.println("Selection Sort Test\n");

		
		System.out.println("Please enter the array size:");
		int inputSize = scan.nextInt();		
		
		System.out.println("Please enter " + inputSize + " values (separate with SPACES not COMMAS)");
		int[] inputArray = new int[inputSize];
		for (int i = 0; i < inputSize; i++){
			inputArray[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println("The original unsorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		long startTime = System.nanoTime();
		
		selectionSort(inputArray, inputSize);
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.println("The new sorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		System.out.println("The runtime for your selected sort is:");
		System.out.println(totalTime + " nanoseconds");
	}
	
	public static void selectionSort(int numbers[], int array_size){
		int i, j, min, temp;
		for (i = 0; i < array_size-1; i++) { 
			min = i;
			for (j = i+1; j < array_size; j++) {
				if (numbers[j] < numbers[min]) min = j;
			}
		temp = numbers[i]; numbers[i] = numbers[min]; numbers[min] = temp;
		}
	}

}
