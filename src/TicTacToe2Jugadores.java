
public class TicTacToe2Jugadores extends TicTacToe {

	public TicTacToe2Jugadores() {
		super();
		this.setJugadores(new Persona[2]);
		this.getJugadores()[0] = new Persona('X');
		this.getJugadores()[1] = new Persona('O');
	}

	public void jugar() {
		do {
			super.getTablero().mostrar();
			if (!super.getTablero().estaCompleto(this.getJugadores()[super.getTurno().tocar()])) {
				this.getJugadores()[super.getTurno().tocar()].ponerFicha(this.getTablero());
			} else {
				this.getJugadores()[super.getTurno().tocar()].moverFicha(super.getTablero());
			}
			super.getTurno().cambiar();
		} while (!super.getTablero().ticTacToe());
		this.getJugadores()[super.getTurno().noToca()].cantarVictoria();
	}
	
}
