package tienda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import plantas.Plantas;

public class Tienda {
	/*
	 * ENUNCIADO:
	 * Debes crer un programa para una tienda de plantas, las plantas son diferentes pero todas son de la misma familia y eso no
	 * se debe poder cambiar, además, la tienda quiere tener la opción de poner descuentos, cambiarlos y quitarlos 
	 * pero solo al iniciar la aplicación, quieren llevar un registro del dinero ganado.
	 * 
	 * Los datos de cada planta vendida deben mostrarse así:
	 * 
	 * Ejemplar: familia-nombre
	 * Tamaño: pequeño/mediano/grande
	 * Precio inicial: x€
	 * Precio final: y€
	 * ***VENDIDA***
	 * 
	 * Al terminar el día debe haber un registro que se verá así:
	 * x€ familia-nombre
	 * x€ familia-nombre
	 * x€ familia-nombre
	 * _________________
	 * y€ TOTAL
	 * 
	 * Hazlo con un menú que te permita seleccionar entre registrar venta, cambiar descuento, cerrar caja y cerrar programa
	 */
	
	public static int leerOpcionValida (Scanner sc, int minimo, int maximo) {
		int a = 0;
		boolean salir = false;
		do {
			try {
				a=sc.nextInt();
				if (a<=maximo && a>=minimo) {
					salir=true;
				} else {
					System.out.println("Introduzca un nº válido");
				}
				
			}
			catch(InputMismatchException ex) {
				System.out.println("Por favor, introduzca un número entero");
				sc.next();
			}
				
		}while (!salir);
		return a;
	}
	public static int leerPrecioValido (Scanner sc, int maximo, int minimo) {
		int pr = 0;
		boolean salir = false;
		do {
			try {
				pr=sc.nextInt();
				if (pr <= maximo && pr >= minimo) {
					salir=true;
				} else {
					System.out.println("Introduzca un precio/descuento válido");
				}
				
			}
			catch(InputMismatchException ex) {
				System.out.println("Por favor, introduzca un número entero");
				sc.next();
			}
				
		}while (!salir);
		return pr;
	}

	public static void main(String[] args) {
		int opc = 0;
		int des = 0;
		String planta;
		String tam;
		int pr = 0;
		boolean salir = false;
	    boolean descuentoEstablecido = false;
		Scanner sc = new Scanner(System.in);
		ArrayList<Plantas> vendidas = new ArrayList<Plantas>();
		
		/*
		 * Utilizo un bucle while para crear el menú
		 */
		while(!salir) {
			
			//Pide que se seleccione una de las 3 opciones, en concreto la opción 2
			System.out.println("Seleccione una opción:\n\t1) Registrar venta\n\t2) Establecer descuento\n\t3) Cerrar caja\n\t");
			opc=leerOpcionValida(sc, 1, 5);

	        //Verificar si el descuento ha sido establecido y en caso de serlo salta a la siquiente iteración con el método
	        //continue
	        if(!descuentoEstablecido && opc != 2) {
	            System.out.println("Debe seleccionar primero la opción 2 para establecer el descuento.");
	            continue;
	        } 

	        // Permitir solo opciones 1 y 3 si el descuento ha sido establecido y si la condición se da sólo se pueden introducir 
	        //las opciones 1 o 3
	        if(descuentoEstablecido && (opc == 2 || opc < 1 || opc > 3)) {
	            System.out.println("Por favor, introduzca una opción válida (1 o 3).");
	            continue;
	        }
			
	        
			switch(opc) {
				//Creación del objeto y registro
				case 1: 
					System.out.println("Indique el nombre de la planta: ");
					planta = sc.next();
					System.out.println("Introduzca el tamaño de la planta: (Es recomendable utilizar palabras significativas)");
					tam = sc.next();
					System.out.println("Introduzca el precio de la planta: ");
					pr = leerPrecioValido(sc, 999999999, 0);
					des = Plantas.descuento;
					
					Plantas p = new Plantas(planta, pr, tam, des);
					vendidas.add(p);
					
					
					
					System.out.println("\n\tEjemplar: " + Plantas.getFamilia() + "-" + planta
									 + "\n\tTamaño: " + tam + "\n\tPrecio inicial: " + pr
									 + "\n\tPrecio final: " + (pr - pr * des / 100) + "\n\t***VENDIDA***");
									
					
				break;
				//Establecer el descuento al inicio de la ejecución
				case 2:
					System.out.println("Esta acción solo podrá realizarla una vez.\nPor favor, seleccione el descuento que desea aplicar:");
					des = leerPrecioValido(sc, 999999999, 0);
					Plantas.descuento = des;
					System.out.println("Ha aplicado un " + des + "% de descuento a todos los productos.");
					descuentoEstablecido = true;
				break;
				//Salir del programa
				case 3:
					salir = true;
				break;
			}
		}
		//Al salir del programa nos genera un registro de ventas
		System.out.println("\nREGISTRO DE VENTAS:");
		int total = 0;
		for (Plantas p : vendidas) {
		    total += p.getPrecioF();
		    System.out.println(p.getPrecioF() + "€" + "\t" + Plantas.getFamilia() + "-" + p.getNombre());
		}
		System.out.println("_________________\n" + total + "€\tTOTAL");
		
		
		sc.close();
	}
}
