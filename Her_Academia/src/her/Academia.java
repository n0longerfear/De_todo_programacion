package her;

import java.util.ArrayList;
import java.util.Scanner;

public class Academia {
	
	public static int capacidad(ArrayList<Aula> listado) {
		int usuariosEliminados = 0;
		for(int i = 0; i < listado.size(); i++) {
			
			while(listado.get(i).limiteCapacidad()==true) {
				listado.get(i).avisoExcesoCapacidad();
				listado.get(i).setUsuarios(listado.get(i).getUsuarios()-1);
				usuariosEliminados += 1;
				
			}
		}
		return usuariosEliminados;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		boolean salir = false;
		int capacidad = 0;
		ArrayList<Aula> listado = new ArrayList<Aula>();
		
		
		
		while(!salir) {
			System.out.println("Elige la clase que quieres crear:\n1)Aula de Informática\n2)Aula de Docencia\n3)Salir");
			opcion=sc.nextInt();
			
			if(opcion != 3) {
				System.out.println("Introduzca la capacidad del aula");
				capacidad=sc.nextInt();
			}
			switch(opcion) {
				case 1:
					System.out.println("1-Mantener número de PCs por defecto\n2-Dar un número de PCs");
					int numPCs = sc.nextInt();
					Informatica i = new Informatica(capacidad);
					if(numPCs == 2) {
						System.out.println("¿Cuántos PCs quiere en el aula?");
						int PCsManual = sc.nextInt();
						i.setnPcs(PCsManual);
					} 
					listado.add(i);
					break;
			
				case 2:
					Docencia d = new Docencia(capacidad);
					listado.add(d);
					break;
			
				case 3:
					salir=true;
					break;
			}
		}
		int usuariosEliminados = capacidad(listado);;
		System.out.println("El número de usuarios eliminados es: " + usuariosEliminados + "\nEl número de aulas"
				+ " creadas es: " + listado.size()); 
		
		sc.close();
	}

}

