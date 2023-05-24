package proyecto;

public class Lavadora extends Electrodomestico{
	private int carga = 5;
	
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	Lavadora(int p, int c){
		super();
		this.carga=c;
		this.setPeso(p);
	}
	Lavadora(int p, int c, char con){
		super();
		this.carga=c;
		this.setPeso(p);
		this.setConsumoEnergetico(con);
	}
	
	public int precioFinal(){
        int precioF = super.precioFinal();
        if (this.carga > 30) {
            precioF += 50;
        }
        return precioF;
    }
	
}
