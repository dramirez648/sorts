// 	Name:			Daniel Ramirez
// 	Sort:     HeapSort

import java.util.Arrays;
import java.util.Scanner;
 
public class HeapSort 
{    
    private static int N;
    /* Sort Function */
    public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
    /* Function to build a heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    /* Main method */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Heap Sort Test\n");
        int inputSize, i;    
        					/* Accept number of elements */
        System.out.println("Please enter the array size:");
        inputSize = scan.nextInt();    
        					/* Make array of n elements */
        int inputArray[] = new int[ inputSize ];
        					/* Accept elements */
        System.out.println("Please enter " + inputSize + " values (separate with SPACES not COMMAS)");
        for (i = 0; i < inputSize; i++)
            inputArray[i] = scan.nextInt();
        					/* Print original Array */
    	System.out.println("The original unsorted array is:");
    	System.out.println(Arrays.toString(inputArray));
        					/* Call method sort */
    	long startTime = System.nanoTime();
        sort(inputArray);
    	long totalTime = System.nanoTime() - startTime;    				
        					/* Print sorted Array */
    	System.out.println("The new sorted array is:");
    	System.out.println(Arrays.toString(inputArray));
        
    	System.out.println("The runtime for your selected sort is:");
    	System.out.println(totalTime + " nanoseconds");
        
        scan.close();
    }    
}
