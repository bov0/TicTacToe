public class Turno {
	
	private int valor;
	
	public Turno() {
		this.valor = 0;
	}

	public int tocar() {
		return this.valor;
	}

	public int noToca() {
		return (this.valor + 1) % 2;
	}

	public void cambiar() {
		this.valor = this.noToca();
	}

	public int getValor() {
		return valor;
	}
	
}