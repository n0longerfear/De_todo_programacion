package paquete;

import java.io.*;

public class Principal {

	public static void main(String[] args) {
		//Crear un objeto de la clase Persona
        Persona persona = new Persona("Juan", 30);

        //este es el proceso que tenemos que realizar para serializar un objeto que se haya creado de
        //una clase que implemente la interfaz serializable
        try {
            //creamos un objeto de la clase fileoutputstream que representa el archivo donde vamos a guardar el objeto
        	//serializado, crea el archivo y lo abre para escribir en el
            FileOutputStream fileOut = new FileOutputStream("persona.ser");
            //creamos un objectoutputstream que indica donde se va a guardar el objeto serializado
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //al llamar el método writeObject y pasarle el objeto, convierte el objeto en una secuencia de bytes y lo 
            //escribe en el archivo indicado. En este paso se realiza la serialización propiamente dicha
            out.writeObject(persona);
            //cerramos el objectoutputstream
            out.close();
            //cerramos el flujo de salida
            fileOut.close();
            //traza de que hemos serializado el objto correctamente
            System.out.println("Objeto serializado correctamente.");
        } catch(IOException i) {
            i.printStackTrace();
        }

        //declaramos otro objeto de la clase persona donde vamos a guardar el objeto deserializado
        Persona personaDeserializada = null;
        
        //este es el proceso para deserializar un objeto serializado
        try {
        	//creamos un objeto fileinputstream que representa el archivo de donde vamos a sacar el objeto serializado,
        	//busca el archivo y lo abre para buscar en el
            FileInputStream fileIn = new FileInputStream("persona.ser");
            //creamos un objectinputstream que indica el fichero donde se encuentra el objeto a deserializar
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //aquí casteamos el resultado de llamar al metodo readObject sobre el objectinputstream a la clase persona y 
            //lo guardamos en el objeto de la clase persona que hemos creado antes e inicializado a nulo para deserializarlo
            personaDeserializada = (Persona) in.readObject();
            //cerramos flujos
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("La clase Persona no se ha encontrado.");
            c.printStackTrace();
        }

        //utilizamos los métodos getNombre y getEdad sobre el objeto deserializado y lo mostramos por pantalla
        System.out.println("Nombre: " + personaDeserializada.getNombre());
        System.out.println("Edad: " + personaDeserializada.getEdad());

	}

}
