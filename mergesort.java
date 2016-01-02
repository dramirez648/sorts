// 	Name:			Daniel Ramirez
// 	Sort:     MergeSort

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
 
      static public void DoMerge(int [] numbers, int left, int mid, int right)
      {
        int [] temp = new int[25];
        int i, left_end, num_elements, tmp_pos;
    
        left_end = (mid - 1);
        tmp_pos = left;
        num_elements = (right - left + 1);
    
        while ((left <= left_end) && (mid <= right))
        {
            if (numbers[left] <= numbers[mid])
                temp[tmp_pos++] = numbers[left++];
            else
                temp[tmp_pos++] = numbers[mid++];
        }
    
        while (left <= left_end)
            temp[tmp_pos++] = numbers[left++];
 
        while (mid <= right)
            temp[tmp_pos++] = numbers[mid++];
 
        for (i = 0; i < num_elements; i++)
        {
            numbers[right] = temp[right];
            right--;
        }
    }
 
    static public void MergeSort_Recursive(int [] numbers, int left, int right)
    {
      int mid;
    
      if (right > left)
      {
        mid = (right + left) / 2;
        MergeSort_Recursive(numbers, left, mid);
        MergeSort_Recursive(numbers, (mid + 1), right);
    
        DoMerge(numbers, left, (mid+1), right);
      }
    }
 
 
    public static void main(String[] args){

	Scanner scan = new Scanner(System.in);
    System.out.println("Merge Sort Test\n");

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
	
	MergeSort_Recursive(inputArray, 0, inputSize - 1);
	
	long totalTime = System.nanoTime() - startTime;
	
	System.out.println("The new sorted array is:");
	System.out.println(Arrays.toString(inputArray));
	
	System.out.println("The runtime for your selected sort is:");
	System.out.println(totalTime + " nanoseconds");
       
    }
}
