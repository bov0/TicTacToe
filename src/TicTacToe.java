public abstract class TicTacToe {

	private Tablero tablero;
	
	private Turno turno;
	
	private Jugador[] jugadores;

	public TicTacToe() {
		this.setTablero(new Tablero());
		this.setTurno(new Turno());
	}

	public abstract void jugar();

	public static void main(String[] args) {
		int opcion = 0;
		if (opcion == 1) {
			TicTacToe2Jugadores ticTacToe2Jugadores = new TicTacToe2Jugadores();
			ticTacToe2Jugadores.jugar();
		} else {
			TicTacToeVSIA ticTacToeVSIA = new TicTacToeVSIA();
			ticTacToeVSIA.jugar();
		}
	}

	protected Turno getTurno() {
		return turno;
	}

	protected void setTurno(Turno turno) {
		this.turno = turno;
	}

	protected Tablero getTablero() {
		return tablero;
	}

	protected void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
}
