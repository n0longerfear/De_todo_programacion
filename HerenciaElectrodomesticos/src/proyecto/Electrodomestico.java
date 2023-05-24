package proyecto;

public class Electrodomestico {
	private int precioBase=100;
	private int peso=5;
	private char consumoEnergetico = 'D';
	
	
	
	public int getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	Electrodomestico (){
	}
	
	Electrodomestico(int pre, int p, char c){
		this.peso=p;
		this.precioBase=pre;
		this.consumoEnergetico=c;
	}
	
	public boolean comprobarConsumoEnergetico() {
        if (consumoEnergetico >= 'A' && consumoEnergetico <= 'D') {
            return true;
        } else {
            return false;
        }
    }
	
	public int precioFinal() {
		
		int precioF = (peso/10*30)+precioBase;
		if(consumoEnergetico=='A') {
			precioF = precioF + 100;
		} else if (consumoEnergetico=='B') {
			precioF = precioF + 80;
		} else if (consumoEnergetico=='C') {
			precioF = precioF + 60;
		} else if (consumoEnergetico=='D') {
			precioF = precioF + 40;
		}
		return precioF;
	}
	
	
}
