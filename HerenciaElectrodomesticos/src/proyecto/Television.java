package proyecto;

public class Television extends Electrodomestico{
	private int resPulgadas=20;

	public int getResPulgadas() {
		return resPulgadas;
	}
	public void setResPulgadas(int resPulgadas) {
		this.resPulgadas = resPulgadas;
	}
	
	Television(int r, int p){
		super();
		this.resPulgadas = r;
		this.setPeso(p);
	}
	Television(int r, int p, char ce){
		super();
		this.resPulgadas = r;
		this.setPeso(p);
		this.setConsumoEnergetico(ce);
	}
	
	public int precioFinal(){
        int precioF = super.precioFinal();
        if (this.resPulgadas > 40) {
            precioF *=1.3;
        }
        return precioF;
        
    }   
}
