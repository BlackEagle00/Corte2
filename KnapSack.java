import java.io.*;
/**
 * 
 * @author Andrés Guillermo Bonilla Olarte
 *
 */
public class KnapSack2 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));	
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	
	static int[] values = new int[] {894, 260, 392, 281, 27};
	static int[] weights = new int[] {21, 8, 6, 5, 4};
	static int W = 30;
	
	private static int knapsack(int i, int W) 
	{
	    if (i < 0)
	    {
	        return 0; //base case
	    }
	    if (weights[i] > W) 
	    {
	        return knapsack(i-1, W); //return index - 1, and W (knapsack weight limit)
	    } 
	    else 
	    {
	        return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]); //Math.max retuurn greater number
	    }
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println(knapsack(values.length - 1, W));
			bw.write(knapsack(values.length - 1, W));
			bw.flush();
		}
		catch (Exception ex)
		{}
	}
}
