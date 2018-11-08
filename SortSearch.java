import java.io.*;
import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @author Andrés Guillermo Bonilla Olarte
 *
 */
public class SortSearchJava 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));     
    static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
    /**
     * 
     * @param a
     * @param n
     */
    public static void bubble_Sort(int a[], int n) 
	{ 
		if (n == 1) 
		{
			return; 
		}
			
		for (int i=0; i<n-1; i++)
		{
			if (a[i] > a[i+1]) 
			{ 
				int temp = a[i]; 
				a[i] = a[i+1]; 
				a[i+1] = temp; 
			} 
		} 
		bubble_Sort(a, n-1); 
	} 	
	/**
	 * 
	 * @param a
	 * @param n
	 */
    public int[] mergeSort(int[] unsortedArray)
	{
		if(unsortedArray.length > 1)
		{
			int n = unsortedArray.length / 2; 
			int[] array_left = new int[n];
			int[] array_right = new int[unsortedArray.length - n]; 
			
			for(int i = 0; i < n; i++) 
				array_left[i] = unsortedArray[i]; 
			
			for(int i = 0; i < array_right.length; i++)
				array_right[i] = unsortedArray[n + i];
			
			array_left = mergeSort(array_left);
			array_right = mergeSort(array_right);
			
			return merge(array_left, array_right);
		}
		else
		{
			return unsortedArray;
		}
	}	
	/**
	 * 
	 * @param array_left
	 * @param array_right
	 * @return
	 */
	public int[] merge(int[] array_left, int[] array_right)
	{
		int[]temp = new int[array_left.length + array_right.length]; 
		int left = 0, right = 0, index = 0;
		
		while(left < array_left.length && right < array_right.length)
		{
			if(array_left[left] <= array_right[right]) 
			{
				temp[index] = array_left[left];
				left += 1;
			}
			else
			{
				temp[index] = array_right[right];
				right += 1;
			}
			
			index += 1;
		}
		
		if(left < array_left.length)
			for(int i = left; i < array_left.length; i++)
			{
				temp[index] = array_left[left];
				left += 1;
				index += 1;
			}	
		else
			for(int i = right; i < array_right.length; i++)
			{
				temp[index] = array_right[right];
				right += 1;
				index += 1;
			}	
		
		return temp;
}
/**
 * 
 * @param a
 * @param n
 */
	public static void insertion_Sort(int a[], int n) 
	{ 	
		for (int i = 1; i < a.length; i++) 
		{
			int x = a[i];
			int index_hole = i;
			while(index_hole > 0 && a [index_hole] > x) 
			{
				a [index_hole] = a [index_hole - 1];
				index_hole -= 1;
			}
			a [index_hole] = x;
		}
	} 
    /**
     * 
     * @param args
     */
	public int interpolationSearch(int[] arrayData, int value)
	{
		int lowerBound = 0;
		int upperBound = arrayData.length - 1;
		int index = -1, middlePoint;
		
		while(lowerBound < upperBound)
		{
			middlePoint = lowerBound + ((upperBound - lowerBound) / (arrayData[upperBound] - arrayData[upperBound])) * (value - arrayData[lowerBound]);
			
			if(middlePoint < lowerBound || middlePoint > upperBound)
				break;
				
			if(value == arrayData[middlePoint])
			{
				index = middlePoint;
				break;
			}
			else
			{
				if(value < arrayData[middlePoint])
					upperBound = middlePoint - 1;
				else
					lowerBound = middlePoint + 1;
			}
		}
		
		if(lowerBound == upperBound && arrayData[lowerBound] == value)
			index = lowerBound;
		
		return index;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{ 
		try 
		{
			int arr[] = {104, 44, 555, 102, 220, 111, 190}; 

			bubble_Sort(arr, arr.length);  //cambiar nombre del Sort
			bw.write("Array Ordenado:"); 
			bw.write(Arrays.toString(arr)); 
			bw.flush();
			
			SortSearchJava sorts = new SortSearchJava();
			arr = sorts.mergeSort(arr);
			bw.flush();
			
			
			int value = 45;
			SortSearchJava searchs = new SortSearchJava();
			System.out.println( searchs.interpolationSearch(arr, value) );
			bw.flush();
		}
		catch
			(Exception ex)
			{
			}
	} 
} 
