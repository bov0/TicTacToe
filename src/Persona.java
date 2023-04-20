
public class Persona extends Jugador {

	public Persona(char color) {
		super(color);
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
	
	protected String errorRetirada(Tablero tablero, Coordenada coordenada) {
		if (!tablero.ocupada(coordenada, super.getColor())) {
			return "Coordenada no ocupada por una ficha " + super.getColor();
		} else {
			return "";			
		}
	}

}
