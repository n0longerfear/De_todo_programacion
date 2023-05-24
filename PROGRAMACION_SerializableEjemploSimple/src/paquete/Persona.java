package paquete;

import java.io.Serializable;
//clase que implementa la interfaz sserializable que significa que sus objetos son serializados, 
//puede tener atributos  que utilicen la palabra clave transient que indica que ese stributo no sería serializable
//osea, no serán incluidos en la secuencia de bytes y no persistirán al guardar o transitir el objeto
public class Persona implements Serializable {
	
	//este atributo sirve para identificar la version dela clase serializada y que no haya errores al 
	//deserializar un objeto porque la version no coincida
	private static final long serialVersionUID = 1L;
	//atributos propios de la clase Persona
	private String nombre;
    private int edad;
    
    //constructor de la clase persona que tiene como parámetros el nombre y la edad para crear un objeto
    //de la clase persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //método para obtener el nombre del objeto persona creado
    public String getNombre() {
        return nombre;
    }

    //método para obtener la edad del objeto persona creado
    public int getEdad() {
        return edad;
    }

}
