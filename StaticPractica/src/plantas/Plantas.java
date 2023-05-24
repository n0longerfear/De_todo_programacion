package plantas;

public class Plantas {
	//Atributos
    private static final String FAMILIA = "Cactaceae";
    private static int contador = 0;
    private String nombre;
    private int precioI;
    private String tamano;
    public static int descuento = 10;
    
    //Constructor
    public Plantas(String nombre, int precioI, String tamano, int descuento) {
        this.nombre = nombre;
        this.precioI = precioI;
        this.tamano = tamano;
        Plantas.descuento = descuento;
        contador++;
    }
    
    //Métodos
    public static void cambiarDescuento(int nuevoDescuento){
        Plantas.descuento = nuevoDescuento;
    }
    
    public double getPrecioF() {
        return precioI - (precioI * descuento / 100);
    }
    
    
    //getters y setters para los atributos de instancia
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Plantas.contador = contador;
	}

	public static int getDescuento() {
		return descuento;
	}

	public static void setDescuento(int descuento) {
		Plantas.descuento = descuento;
	}

	public static String getFamilia() {
		return FAMILIA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	
    
    
}
