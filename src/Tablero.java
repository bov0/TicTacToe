public class Tablero {

	private char[][] casillas;

	public static final int DIMENSION = 3;

	public static final char VACIA = '_';

	public Tablero() {
		this.casillas = new char[DIMENSION][DIMENSION];
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				this.casillas[i][j] = VACIA;
			}
		}
	}

	public void mostrar() {
		GestorIO gestorIO = new GestorIO();
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				gestorIO.out(this.casillas[i][j] + "  ");
			}
			gestorIO.out(' ');
			gestorIO.out('\n');
		}
	}

	public boolean ticTacToe() {
		return this.ticTacToe('X') || this.ticTacToe('O');
	}

	private boolean ticTacToe(char color) {
		int[] filas = new int[DIMENSION];
		int[] columnas = new int[DIMENSION];
		int diagonal = 0;
		int diagonalSecundaria = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (this.casillas[i][j] == color) {
					filas[i]++;
					columnas[j]++;
					if (i == j) {
						diagonal++;
					}
					if (i + j == 2) {
						diagonalSecundaria++;
					}
				}
			}
		}
		if (diagonal == DIMENSION || diagonalSecundaria == DIMENSION) {
			this.mostrar();
			return true;
		} else {
			for (int i = 0; i < DIMENSION; i++) {
				if (filas[i] == DIMENSION || columnas[i] == DIMENSION) {
					this.mostrar();
					return true;
				}
			}
		}
		return false;
	}

	public boolean estaCompleto(Jugador jugador) {
		int fichas = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (this.casillas[i][j] == jugador.getColor()) {
					fichas++;
				}
			}
		}
		return fichas == DIMENSION;
	}

	public void ponerFicha(Coordenada coordenada, char color) {
		this.casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = color;
	}

	public void retirar(Coordenada coordenada) {
		this.ponerFicha(coordenada, VACIA);
	}

	public boolean ocupada(Coordenada coordenada, char color) {
		return this.casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] == color;
	}

	public boolean ocupada(Coordenada coordenada) {
		return !this.ocupada(coordenada,VACIA);
	}

	public char[][] getCasillas() {
		return casillas;
	}
}
