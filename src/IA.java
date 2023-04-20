public class IA extends Jugador {

	public IA(char color) {
		super(color);
	}
	
	protected void ponerFicha(Tablero tablero) {
		if (turno1()) {
			tablero.getCasillas()[2][2] = super.getColor();
		} else {
			
		}
	}
	
	private void ponerFichaTurno1(Tablero tablero, Turno turno) {
		if (tablero.getCasillas()[2][2] == ' ' && turno.getValor() == 1) {
			tablero.getCasillas()[2][2] = super.getColor();
		}
	}
	
	protected Coordenada recogerCoordenadaValida(Tablero tablero, Coordenada coordenadaRetirada) {
		Coordenada coordenada = new Coordenada();
		String error;
		do {
			error = "";
			coordenada.recoger();
			error = this.errorPuesta(tablero,coordenada,coordenadaRetirada);
			if (error != "") {
				new GestorIO().out("ERROR! " + error);
				new GestorIO().out("\n");
			}
		} while (error != "");
		return coordenada;
	}

	protected Coordenada recogerCoordenadaRetirada(Tablero tablero) {
		Coordenada coordenada = new Coordenada();
		String error;
		do {
			error = "";
			coordenada.recoger();
			error = this.errorRetirada(tablero,coordenada);
			if (error != "") {
				new GestorIO().out("ERROR! " + error);
				new GestorIO().out("\n");
			}
		} while (error != "");
		return coordenada;
	}

}
