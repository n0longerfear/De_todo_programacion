package contactos;
//Esta es la clase que se va a serializar
public class Contacto implements java.io.Serializable{
	//ATRIBUTOS DE LA CLASE
	//Este atributo es una constante que ayuda a garantizar que las versiones serializadas y deserializadas 
	//de la clase sean compatibles entre sí
	private static final long serialVersionUID = 1L;
	//estos son los atributos de la clase que van a formar el constructor
	protected String nombre;
	protected long tlfMovil;
	protected String email;
	//La variable tlfFijo no se serializará porque es transient, lo que significa que al serializar el 
	//objeto, este campo no se serializará entonces se pierde aunque en el constructor esté inicializado 
	//con otro valor y volverá a su valor por defecto que en este caso es 0 porque es el valor por defecto
	//para los atributos numericos, si fuera un string daría igual que lo inicializara como "a" aquí y como
	//"b" en el constructor, al deserializarlo, este dato de pierde así que se mostraría como nulo
	protected transient long tlfFijo = 1;
	
	//Constructor de la clase contacto
	public Contacto(String nombre, long tlfMovil, String email) {
		this.nombre = nombre;
		this.tlfMovil = tlfMovil;
		this.email = email;
		//Este valor no se serializa por la palabra clave transient
		tlfFijo = 2;
	}
	
	//Método para imprimir el objeto Contacto en una cadena de texto, esto se imprime cuando imprimimos un objeto de la 
	//clase contacto y utilizamos el metodo toString sobre el
	public String toString() {
		return ("Contacto: " + nombre + "\nTeléfono móvil: " + tlfMovil + "\nTeléfono fijo: " + tlfFijo + "\nEmail: " + email);
	}
}
