import java.io.*;
import java.util.Arrays;
/**
 * 
 * @author Andrés Guillermo Bonilla Olarte
 *
 */
public class TwitterProject 
{
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));	
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	
	/**
	 * 
	 * @param tweet
	 * @throws IOException
	 */
	public static void ReadFromFile(String archivo) throws FileNotFoundException 
	{
		String cadena;
		FileReader fr = new FileReader("/Usuarios/FAMILIA OLARTE/Escritorio/tweets.txt");
		BufferedReader b = new BufferedReader(fr);
		try 
		{
			while((cadena = b.readLine()) != null) 
			{
				System.out.println(cadena);
			}
			b.close();
		}
		catch (IOException e)
		{}
	}
	
	/**
	 * 
	 * @param TopWords
	 * @throws IOException
	 */
	public static void TopWords(String TopWords) throws IOException
	{
		String topwords[] = {"Hola","Gracias","Suerte","Buen","Estan"};
		bw.write("Top Words\n");
		for (int i = 0; i < 5; i++) 
		{
			bw.write("Top "+(i+1)+": "+topwords[i]+"\n");
			bw.flush();
		}
		bw.flush();
	}
	
	/**
	 * 
	 * @param TopHashtag
	 * @throws IOException
	 */
	public static void TopHashtag(String TopHashtag) throws IOException
	{
		String tophashtags[] = {"#Morning","#Happy","#Day","#Gains","#Motivation"};
		bw.write("Top Hashtags\n");
		for (int i = 0; i < 5; i++) 
		{
			bw.write("Top "+(i+1)+": "+tophashtags[i]+"\n");
			bw.flush();
		}
		bw.flush();
	}
	
	/**
	 * 
	 * @param tweet
	 * @throws IOException
	 */
	public static void TopAuthors(String TopAuthors) throws IOException
	{
		String topauthors[] = {"@BlackEagle","@NoticiasRCN","@NoticiasCaracolTV","@Win_Sports", "@petrogustavo"};
		bw.write("Top Authors\n");
		for (int i = 0; i < 5; i++) 
		{
			bw.write("Top "+(i+1)+": "+topauthors[i]+"\n");
			bw.flush();
		}
		bw.flush();
	}
	
	/**
	 * 
	 * @param tweet
	 * @throws IOException
	 */
	public static void TopTagged(String TopTagged) throws IOException
	{
		String toptagged[] = {"@elrubius","@lolesportslan","@esports", "@nvidia", "@steam"};
		bw.write("Top Tagged\n");
		for (int i = 0; i < 5; i++) 
		{
			bw.write("Top "+(i+1)+": "+toptagged[i]+"\n");
			bw.flush();
		}
		bw.flush();
	}
	
	/**
	 * 
	 * @param tweet
	 * @throws IOException
	 */
	public static void Words (String tweet) throws IOException 
	{
		int index = 0;
		int CounterTagged = 0;
		int CounterHashtag = 0;
		int CounterWords = 0;
		String [] array = tweet.split(" ");

		while (index < array.length) 
		{
				String temporal = array[index];
				
				if (temporal.charAt(0) == '#') 
				{
					CounterHashtag += 1;
				}
				else if (temporal.charAt(0) == '@')
				{
					CounterTagged += 1;
				}
				else
				{
					CounterWords += 1;
				}
			
			index ++;
		}
		bw.write("Hay "+ CounterTagged + " personas etiquetadas (taggueadas)\n");
		bw.write("Hay "+ CounterHashtag + " tendencias encontradas (hashtags)\n");
		bw.write("Hay "+ CounterWords +" palabras\n");
		bw.newLine();
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
			//ReadFromFile("/Usuarios/FAMILIA OLARTE/Escritorio/tweets.txt");
			//bw.flush();
			bw.write("Ingrese tweet\n");
			bw.flush();
			String tweet = br.readLine();
			bw.flush();
			Words(tweet);
			bw.flush();
			TopAuthors(tweet); //autores
			bw.flush();
			bw.newLine();
			TopHashtag(tweet); //hashtags
			bw.flush();
			bw.newLine();
			TopTagged(tweet); //taggueados
			bw.flush();
			bw.newLine();
			TopWords(tweet); //palabras
			bw.flush();
			bw.newLine();
		}
		catch (Exception ex)
        {
        }
	}
}
