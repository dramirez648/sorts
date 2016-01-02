// 	Name:			Daniel Ramirez
// 	Sort:     QuickSort (Median of Three pivot)

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort3 {
	
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Quick Sort Third Test\n");
	    
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
		
	quickSort(inputArray);
		
	long totalTime = System.nanoTime() - startTime;
		
	System.out.println("The new sorted array is:");
	System.out.println(Arrays.toString(inputArray));
		
	System.out.println("The runtime for your selected sort is:");
	System.out.println(totalTime + " nanoseconds");
	
  }

  public static void quickSort(int[] intArray) {
    recQuickSort(intArray, 0, intArray.length - 1);
  }

  public static void recQuickSort(int[] intArray, int left, int right) {
    int size = right - left + 1;
    if (size <= 3)
      manualSort(intArray, left, right);
    else {
      double median = medianOf3(intArray, left, right);
      int partition = partitionIt(intArray, left, right, median);
      recQuickSort(intArray, left, partition - 1);
      recQuickSort(intArray, partition + 1, right);
    }
  }

  public static int medianOf3(int[] intArray, int left, int right) {
    int center = (left + right) / 2;

    if (intArray[left] > intArray[center])
      swap(intArray, left, center);

    if (intArray[left] > intArray[right])
      swap(intArray, left, right);

    if (intArray[center] > intArray[right])
      swap(intArray, center, right);

    swap(intArray, center, right - 1);
    return intArray[right - 1];
  }

  public static void swap(int[] intArray, int dex1, int dex2) {
    int temp = intArray[dex1];
    intArray[dex1] = intArray[dex2];
    intArray[dex2] = temp;
  }

  public static int partitionIt(int[] intArray, int left, int right, double pivot) {
    int leftPtr = left;
    int rightPtr = right - 1;

    while (true) {
      while (intArray[++leftPtr] < pivot)
        ;
      while (intArray[--rightPtr] > pivot)
        ;
      if (leftPtr >= rightPtr)
        break;
      else
        swap(intArray, leftPtr, rightPtr);
    }
    swap(intArray, leftPtr, right - 1);
    return leftPtr;
  }

  public static void manualSort(int[] intArray, int left, int right) {
    int size = right - left + 1;
    if (size <= 1)
      return;
    if (size == 2) {
      if (intArray[left] > intArray[right])
        swap(intArray, left, right);
      return;
    } else {
      if (intArray[left] > intArray[right - 1])
        swap(intArray, left, right - 1);
      if (intArray[left] > intArray[right])
        swap(intArray, left, right);
      if (intArray[right - 1] > intArray[right])
        swap(intArray, right - 1, right);
    }
  }

}
