public class Coordenada {
	
	private int fila;
	
	private int columna;
	
	public static final Intervalo LIMITES = new Intervalo(1,3);
	
	public Coordenada() {
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}

	public void recoger() {
		GestorIO gestorIO = new GestorIO();
		boolean error;
		do {
			error = false;
			gestorIO.out("Introduce fila [1,3]: ");
			gestorIO.out('\n');
			this.fila = gestorIO.inInt();
			gestorIO.out("Introduce columna [1,3]: ");
			gestorIO.out('\n');
			this.columna = gestorIO.inInt();
			error = !this.valida();
			if (error) {
				gestorIO.out("ERROR!! Valores fuera de rango");
				gestorIO.out('\n');
			}
		} while (error);
	}

	private boolean valida() {
		return LIMITES.incluye(this.fila) && LIMITES.incluye(this.columna);
	}

	public boolean igual(Coordenada coordenada) {
		return this.fila == coordenada.getFila() && this.columna == coordenada.getColumna();
	}
}
