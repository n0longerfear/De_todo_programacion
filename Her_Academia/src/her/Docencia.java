package her;

public class Docencia extends Aula{
	
	
	public Docencia(int usuarios) {
		super();
		this.setM2((int)(getM2()*1.2));
		setUsuarios(usuarios);
		
		
	}
	public void avisoExcesoCapacidad() {
		if(limiteCapacidad()==true) {
			System.out.println("Cuidado, has superado la capacidad máxima del aula de Docencia");
		} 
		
	}


	
	
}
