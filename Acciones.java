import java.io.*;
/**
 * 
 * @author Andrés Guillermo Bonilla Olarte
 *
 */
public class Acciones
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static int [] valor (String valor)
	{
		String valores [] = valor.split(" "); // Crear un string de nombre "valores" y separarlo por espacio
		int [] valores_int = new int[valores.length]; // Crear arreglo "valores_int" e igualarlo al tamaño del string anterior
		
		for (int i = 0; i < valores.length; i++) //Recorrer el arreglo "valores"
		{ 
			valores_int [i] = Integer.parseInt(valores [i]);//Convertir el arreglo, en un tipo entero
		}
		return valores_int;
	}
	/**
	 * 
	 * @param valores
	 * @return
	 */
	public static int dia_compra(int [] valores)  //Función para el día de compra de acciones
	{
		int menor = valores [0]; //Variable que toma la posición 0 del arreglo
		int indice = 0; //Crear variable "indice", inicializada en 0, que guarda el índice del valor menor
		for (int i = 0; i < valores.length - 2; i++) //Recorrer el array, menos la ultima posición
		{
			if (menor > valores[i+1]) 
			{
				menor = valores[i+1];//Guarda el valor del precio más bajo
				indice = (i + 1);//Guarda el índice del precio más bajo
			}
		}
		return indice;
	}
	
	public static int dia_venta(int [] valores, int dia) //Función para el día de venta de acciones
	{
		int mayor = valores [dia];//Create a variable that takes the position 0 of the values array
		int indice = 0;//Create a variable that will be save the index of higher price
		for (int i = dia; i < valores.length-1; i++) //Go trhough the array, except the last position
		{
			if (mayor < valores[i+1]) 
			{
				mayor = valores[i+1];//Save the value of the higher price
				indice = (i + 1);//Save the index of the higher price
			}
		}
		return indice;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main (String [] args) 
	{
		try 
		{
			bw.write("Ingrese número de semanas: \n"); //Pedir número de semanas
			bw.flush(); //liberar información
			int semanas = Integer.parseInt(br.readLine()); //Lee número de semanas
			for (int i = 1; i <= semanas; i++) // Recorre semana tras semana
			{ 
				bw.write("Semana " + i + ": Ingrese los valores de la acción durante la semana: \n"); //Pedir valores de la acción
				bw.flush(); //liberar información
				
				String valores = br.readLine(); //Leer los valores
				int [] valores_int = valor(valores); // Convierte el String "valores", en un arreglo
				int compra = dia_compra(valores_int);//Llama la función de compra
				int venta = dia_venta(valores_int, compra);//Llama la función de venta+
				int ganancia_semana = venta - compra;
				int ganancia_total = 0; 
				if(compra < venta) 
				{
					bw.write("Comprar acción el día " + (compra + 1)+"\n");
					bw.write("Vender acción el día " + (venta + 1) + " para obtener ganancias\n");
					bw.flush(); //liberar información
					bw.write("Ganancia de la semana: "+ganancia_semana+"\n");
					bw.flush(); //liberar información
				}
				else 
				{
					bw.write("No se puede realizar la operación\n");
					bw.flush();
					bw.write("No se puede vender la acción, y luego comprarla\n");
					bw.flush();
				}
				ganancia_total += ganancia_semana;
				bw.flush();
				bw.write("Ganancia total: "+ganancia_total+"\n");
				bw.flush(); //liberar información
			}
		}
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}
