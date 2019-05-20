package grafico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class prueba {

	public static void guardar(String usuario) throws IOException {
		
		FileWriter writer= new FileWriter("src/Proyecto/RecordarUsuario");
		writer.write(usuario);
		writer.close();


	}
	
	
	public static String recordar() throws IOException {
		String text= "";
		
		String ruta = "src/Proyecto/RecordarUsuario";
		File fichero = new File(ruta);
		Scanner sc = new Scanner(fichero);
		
		while(sc.hasNextLine()) {
			text += sc.nextLine();
			
		}
		
		return text;
		
	}
	
}