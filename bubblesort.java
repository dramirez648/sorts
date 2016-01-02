// 	Name:			Daniel Ramirez
// 	Sort:     BubbleSort

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	    System.out.println("Bubble Sort Test\n");
		
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
		
		bubbleSort(inputArray, inputSize);
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.println("The new sorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		System.out.println("The runtime for your selected sort is:");
		System.out.println(totalTime + " nanoseconds");

	}
	
	public static void bubbleSort(int numbers[], int array_size){
		int i, j, temp;
		for (i = (array_size - 1); i >= 0; i--){
			for (j = 1; j <= i; j++){
				if (numbers[j-1] > numbers[j]){
					temp 			= 	numbers[j-1];
					numbers[j-1] 	= 	numbers[j];
					numbers[j] 		=	temp;
				}
			}
		}
	}

}
