// 	Name:			Daniel Ramirez
// 	Sort:     ShellSort

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort { 
 
    public static void shellSort(int numbers[], int array_size) 
    {
        int increment = array_size / 2;
        while (increment > 0) 
        {
            for (int i = increment; i < array_size; i++) 
            {
                int j = i;
                int temp = numbers[i];
                while (j >= increment && numbers[j - increment] > temp) 
                {
                    numbers[j] = numbers[j - increment];
                    j = j - increment;
                }
                numbers[j] = temp;
            }
            if (increment == 2)
                increment = 1;
            else
                increment *= (5.0 / 11);
 
        }
    }
 
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	    System.out.println("Shell Sort Test\n");
		
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
		
		shellSort(inputArray, inputSize);
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.println("The new sorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		System.out.println("The runtime for your selected sort is:");
		System.out.println(totalTime + " nanoseconds");

	}
}
