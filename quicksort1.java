// 	Name:			Daniel Ramirez
// 	Sort:     QuickSort (Recursive/Right-most pivot)

import java.util.Arrays;
import java.util.Scanner;
 
public class QuickSort1 {
 
      public static int Partition(int[] numbers, int left, int right)
    {
        int pivot = numbers[right];
        while (true)
        {
            while (numbers[left] < pivot)
                left++;
 
            while (numbers[right] > pivot)
                right--;
 
            if (left < right)
              {
                int temp = numbers[right];
                numbers[right] = numbers[left];
                numbers[left] = temp;
              }
              else
              {
                    return right;
              }
        }
    }
 
      public static void QuickSort_Recursive(int[] arr, int left, int right)
    {
        // For Recursion
        if(left < right)
        {
            int pivot = Partition(arr, left, right);
 
            if(pivot > 1)
                QuickSort_Recursive(arr, left, pivot - 1);
 
            if(pivot + 1 < right)
                QuickSort_Recursive(arr, pivot + 1, right);
        }
    }
 
    public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
	    System.out.println("Quick Sort First Test\n");
	    
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
		
		QuickSort_Recursive(inputArray, 0, inputSize-1);
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.println("The new sorted array is:");
		System.out.println(Arrays.toString(inputArray));
		
		System.out.println("The runtime for your selected sort is:");
		System.out.println(totalTime + " nanoseconds");
       
    }
}
