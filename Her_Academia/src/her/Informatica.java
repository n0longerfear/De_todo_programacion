package her;

public class Informatica extends Aula{
	private int nPcs;
	
	
	
	public int getnPcs() {
		return nPcs;
	}
	public void setnPcs(int nPcs) {
		this.nPcs = nPcs;
	}

	
	public Informatica(int usuarios) {
		super();
		this.setM2((int)(getM2()*0.8));
		this.setnPcs(getM2()/2);
		setUsuarios(usuarios);
	}
	
	
	public boolean limiteCapacidad(int usuarios) {
		if (nPcs >= usuarios) {
			return false;
		} else {
			return true;
		}
	}
	
	//Método propio 
	public void avisoExcesoCapacidad(){
		if(limiteCapacidad()==true) {
			System.out.println("***Cuidado, ha superado la capacidad máxima del aula de Informática***");
		} 
	}
}
