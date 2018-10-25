import java.io.*;

/**
 * 
 * @author Andrés Guillermo Bonilla Olarte
 *
 */

public class TwitterProject 
{
	
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));	
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	
	public static void WordsCounter (String text) throws IOException 
	{
		int index = 0;
		int CountTag = 0;
		int CountHash = 0;
		int CountPost = 0;
		String [] array = text.split(" ");
		
		
		
		while (index < array.length) 
		{
				
				String temporal = array[index];
				label:if (array.length <= 3) 
				{
					bw.write("Texto no admitido: Tamaño muy corto\n");
					break label;
				}
					
				if (temporal.charAt(0) == '#') 
				{
					CountHash += 1;
				}
				else if (temporal.charAt(0) == '@')
				{
					CountTag += 1;
				}
				else
				{
					CountPost += 1;
				}
			
			index ++;
		}
		
		bw.write("Hay "+ CountTag + " personas etiquetadas (taggueadas)\n");
		bw.write("Hay "+ CountHash + " tendencias encontradas (hashtags)\n");
		bw.write("Hay "+ CountPost +" palabras\n");
		bw.flush();
		
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main (String [] args) 
	{
		try 
		{
			bw.write("Ingrese texto\n");
			bw.flush();
			String text = br.readLine();
			bw.flush();
			WordsCounter(text);
			bw.flush();
		}
		catch (Exception ex)
        {
        }
	}
}
