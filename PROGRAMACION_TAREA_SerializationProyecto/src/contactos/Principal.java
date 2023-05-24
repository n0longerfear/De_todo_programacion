package contactos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) {
		//se crean unos arrays con nombres emails y tlf moviles, esto sirve para luego crear los objetos de forma más dinámica
		//en un bucle for
		String[] nombres = {"Ana", "Juan", "Alberto", "Claudia"};
		String[] emails = {"ana@gmail.com", "juan@gmail.com", "alberto@gmail.com", "claudia@gmail.com"};
		long[] moviles = {111111111, 222222222, 333333333, 444444444};
		
		//se crea un objeto file que representa el fichero donde se van a guardar los contactos serializados
		File f = new File("contactos.dat");
		
		try {
			//creamos un fileoutputstream que sirve para abrir un flujo de escritura
			FileOutputStream fos = new FileOutputStream(f);
			//creamos un objeto de la clase objectoutputstream que sirve para indicar que la escritura de los objetos 
			//serializados se va a realizar en el fichero que indica el fileoutputstream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//en este bucle se crean los objetos y se serializan y escriben mediante el método writeObject que llamamos
			//con el objeto objectoutputstream y le pasamos como parámetro cada objeto creado
			for(int i = 0; i < 4; i++) {
				Contacto c = new Contacto(nombres[i], moviles[i], emails[i]);
				oos.writeObject(c);
			}
			
			//Cerrar los flujos creados
			if(oos != null) {
				oos.close();
				fos.close();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		//Si el archivo existe, leer los contactos serializados
		if(f.exists()) {
			try {
				//creamos un fileinputstream que abre el flujo de entrada del fichero para poder leerlo
				FileInputStream fis = new FileInputStream(f);
				//creamos un objectinputstream que sirve para indicar que se va a leer el fichero indicado en el
				//fileinputstream
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//este bucle se realiza hasta que se produzca una excepción
				while(true) {
					//creamos un objeto de la clase contacto inicializado a nulo
					Contacto c = null;
					//leemos el primer objeto con el metodo readObject de objectinputstream, lo casteamos a un
					//tipo contacto y lo guardamos en el objeto de la clase contacto que hemos creado
					c = (Contacto)ois.readObject();
					//imprimimos el objeto contacto usando el método toString que hemos sobreescrito en la 
					//clase contacto y nos muestra toda la información del objeto
					System.out.println(c.toString());
				}
			//esta es la excepción que nos saca del bucle while
			} catch(EOFException ee) {
				// Capturar la excepción que se lanza cuando se llega al final del archivo
				// Imprimir un mensaje de fin de archivo
				System.out.println("***** FIN DE CONTACTOS *****");
				
			} catch(IOException e) {
				// Capturar la excepción de entrada/salida
				// Imprimir un mensaje de error
				System.err.println(e.getMessage());
			} catch(ClassNotFoundException cnf) {
				// Capturar la excepción de clase no encontrada
				// Imprimir un mensaje de error
				System.err.println(cnf.getMessage());
			}
		}
	}
}
