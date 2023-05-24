package proyecto;

import java.util.ArrayList;

public class Principal {
	

	public static void main(String[] args) {
		ArrayList<Electrodomestico> arrElec = new ArrayList<Electrodomestico>();
		int precioTotal = 0;
		int numeroElectrodomesticos=0;
		
		Lavadora l1 = new Lavadora(30, 60, 'B');
		Lavadora l2 = new Lavadora(30, 45, 'F');
		Television t1 = new Television(30, 35, 'C');
		Television t2 = new Television(50, 20, 'A');
		Television t3 = new Television(50, 20, 'E');
		
		arrElec.add(l1);
		arrElec.add(l2);
		arrElec.add(t1);
		arrElec.add(t2);
		arrElec.add(t3);
		
		
		
		for (Electrodomestico electrodomestico : arrElec) {
			if(electrodomestico.comprobarConsumoEnergetico()) {
				precioTotal += electrodomestico.precioFinal();
				
			} else {
				System.out.println("***Electrodoméstico con tipo de consumo energético no aceptado***");
			}
			
			numeroElectrodomesticos++;
		}
		
		System.out.println("Precio total: " + precioTotal);
		System.out.println("Número de electrodomesticos creados: " + numeroElectrodomesticos);

	}

}
