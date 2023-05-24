package her;

public abstract class Aula {
	
	//Atributos
	private int m2 = 30;
	private int usuarios=0;
	
	//Getters y setters
	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	
	public int getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(int usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean limiteCapacidad() {
		if(m2/usuarios <= 1) {
			return true;
		} else return false;
	}
	
	public abstract void avisoExcesoCapacidad();
}
