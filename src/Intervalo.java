public class Intervalo {

	// Atributos
	private double extremoSuperior;
	private double extremoInferior;

	// Constructores
	public Intervalo(double extremoInferior, double extremoSuperior) {
		this.extremoSuperior = extremoSuperior;
		this.extremoInferior = extremoInferior;
	}

	public Intervalo(Intervalo IntervaloAntiguo) {
		this(IntervaloAntiguo.getExtremoInferior(), IntervaloAntiguo.getExtremoSuperior());
	}

	public Intervalo(double extremoSuperior) {
		this.extremoInferior = 0;
	}

	public Intervalo() {
		this.extremoInferior = 0;
		this.extremoSuperior = 0;
	}
	// Métodos
	private double getExtremoInferior() {
		return this.extremoInferior;
	}

	private double getExtremoSuperior() {
		return this.extremoSuperior;
	}
	
	public double longitud() {
		return this.extremoSuperior-this.extremoInferior;
	}

	public double puntoMedio() {
		return (this.extremoInferior+this.extremoSuperior)/2;
	}
	
	public void desplazar(double desplazamiento) {
		this.extremoInferior = this.extremoInferior +desplazamiento;
		this.extremoSuperior = this.extremoSuperior + desplazamiento;
	}

	public boolean iguales(Intervalo IntervaloAntiguo) {
		return this.extremoInferior == IntervaloAntiguo.getExtremoInferior() && this.extremoSuperior == IntervaloAntiguo.getExtremoSuperior();
	}

	public void copiar(Intervalo IntervaloAntiguo) {
		this.extremoInferior = IntervaloAntiguo.getExtremoInferior();
		this.extremoSuperior = IntervaloAntiguo.getExtremoSuperior();
	}

	public Intervalo clonar() {
		return new Intervalo(this.extremoInferior, this.extremoSuperior);
	}
	
	public boolean incluye(double valor) {
		return this.extremoInferior <= valor && valor <= this.extremoSuperior;
	}
	
	public boolean incluyeIntervalo(Intervalo intervalo) {
		return this.extremoInferior <= intervalo.extremoInferior && intervalo.extremoSuperior <= this.extremoSuperior;
	}
	
	public Intervalo interseccion(Intervalo intervalo) {
		if(this.intersecta(intervalo)) {
			if(this.incluyeIntervalo(intervalo)) {
				return intervalo.clonar();
			}else if(intervalo.incluyeIntervalo(this)) {
				return this.clonar();
			}else if(intervalo.incluye(this.extremoInferior)) {
				return new Intervalo(this.extremoInferior, intervalo.getExtremoSuperior());
			}else {
				return new Intervalo(intervalo.getExtremoInferior(),this.extremoSuperior);
			}
		}else {
			return null;
		}
	}
	
	public boolean intersecta(Intervalo intervalo) {
		return intervalo.incluye(this.extremoInferior) || intervalo.incluye(this.extremoSuperior) || this.incluyeIntervalo(intervalo);
	}

	public void oponer() {
		double aux = this.extremoInferior*(-1);
		this.extremoInferior = this.extremoSuperior*(-1);
		this.extremoSuperior = aux;
	}

	public void doblar() {
		this.extremoInferior = this.extremoInferior / 2;
		this.extremoSuperior = this.extremoSuperior *2;
	}

	public void mostrar() {
		System.out.println("(" + this.extremoInferior + "," + this.extremoSuperior + ")");
	}

	public void establecer() {
		//No entiendo que quiere hacer el metodo establecer
	}

	public Intervalo[] troceado(int trozos) {
		Intervalo[] arrayTrozos = new Intervalo[trozos];
		double trozo = this.longitud() / trozos;
		for (int i = 0; i < arrayTrozos.length; i++) {
			arrayTrozos[i] = new Intervalo(this.extremoInferior + (i*1), trozo * (i+1));
			arrayTrozos[i].mostrar();
		}
		return arrayTrozos;
	}
}
