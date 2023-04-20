public abstract class Jugador {

	private char color;

	public Jugador(char color) {
		this.color = color;
	}

	public char getColor() {
		return this.color;
	}

	protected void ponerFicha(Tablero tablero) {
		this.ponerFicha(tablero,null);
	}

	public void moverFicha(Tablero tablero) {
		new GestorIO().out("Mueve el jugador " + this.color);
		new GestorIO().out("\n");
		Coordenada coordenadaRetirada = this.recogerCoordenadaRetirada(tablero);
		tablero.retirar(coordenadaRetirada);
		tablero.mostrar();
		this.ponerFicha(tablero,coordenadaRetirada);
	}

	protected void ponerFicha(Tablero tablero, Coordenada coordenadaRetirada) {
		new GestorIO().out("Pone el jugador " + this.color);
		new GestorIO().out("\n");
		tablero.ponerFicha(this.recogerCoordenadaValida(tablero,coordenadaRetirada),this.color);
	}

	protected abstract Coordenada recogerCoordenadaValida(Tablero tablero, Coordenada coordenadaRetirada);

	protected String errorPuesta(Tablero tablero, Coordenada coordenada, Coordenada coordenadaRetirada) {
		if (tablero.ocupada(coordenada)) {
			return "Coordenada ocupada por otra ficha";
		} else if (coordenadaRetirada != null && coordenadaRetirada.igual(coordenada)) {
			return "No se puede poner de donde se quitó";
		}
		return "";
	}

	protected abstract Coordenada recogerCoordenadaRetirada(Tablero tablero);

	protected String errorRetirada(Tablero tablero, Coordenada coordenada) {
		if (!tablero.ocupada(coordenada, this.color)) {
			return "Coordenada no ocupada por una ficha " + this.color;
		} else {
			return "";			
		}
	}

	public void cantarVictoria() {
		new GestorIO().out("VICTORIA!! Ha ganado el jugador " + this.color);
		new GestorIO().out("\n");
	}
}
