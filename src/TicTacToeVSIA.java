
public class TicTacToeVSIA extends TicTacToe {
	
	public TicTacToeVSIA() {
		super();
		this.getJugadores()[0] = new Persona('X');
		this.getJugadores()[1] = new IA('O');
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
