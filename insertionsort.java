// 	Name:			Daniel Ramirez
// 	Assignment #:	5
//	Problem #:		3

import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	    System.out.println("Insertion Sort Test\n");

		
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
		
		insertionSort(inputArray, inputSize);
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.println("The new sorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		System.out.println("The runtime for your selected sort is:");
		System.out.println(totalTime + " nanoseconds");
		
	}
	
	static void insertionSort(int numbers[], int array_size){
		int i, j, index;
		for (i = 1; i < array_size; i++){
			index = numbers[i];
			j = i;
			while ((j > 0) && (numbers[j-1] > index)) {
				numbers[j] = numbers[j-1];
				j = j-1; 
			}
			numbers[j] = index; 
		}
	}

}
